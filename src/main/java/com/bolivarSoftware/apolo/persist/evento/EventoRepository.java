package com.bolivarSoftware.apolo.persist.evento;

import com.bolivarSoftware.apolo.beans.Pagination;
import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.ServicioContratado;
import com.bolivarSoftware.apolo.persist.CloseableSession;
import com.bolivarSoftware.apolo.persist.interfaces.IEventoRepository;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EventoRepository implements IEventoRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Evento save(Evento evento) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().beginTransaction();
            session.delegate().saveOrUpdate(evento);
            tx.commit();

            return evento;
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }


    @Override
    public List<Evento> findAllPageable(Integer pageNumber) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query = session.delegate().createQuery("from Evento");
            query.setFirstResult((pageNumber - 1) * Pagination.MAX_PAGE );
            query.setMaxResults(Pagination.MAX_PAGE);

            return query.list();
        }
        catch (HibernateException e){
            throw e;
        }
    }

    @Override
    public void remove(Integer id) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().getTransaction();
            tx.begin();
            Evento evento = (Evento) session.delegate().get(Evento.class, id);
            Hibernate.initialize(evento.getServicios());
            evento.getServicios().forEach(servicioContratado -> servicioContratado.getEtapas().forEach(etapaARealizar -> session.delegate().delete(etapaARealizar)));
            evento.getServicios().forEach(servicioContratado -> session.delegate().delete(servicioContratado));
            session.delegate().delete(evento);
            tx.commit();
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }

    @Override
    public List<Evento> findAll() {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            return  session.delegate().createQuery("from Evento").list();
        }
        catch (HibernateException e){
            throw e;
        }
    }

    @Override
    public Evento get(Integer integer) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Evento evento = (Evento) session.delegate().get(Evento.class, integer);
            Hibernate.initialize(evento.getServicios());

            return evento;
        }
        catch (HibernateException e){
            throw e;
        }
    }

    @Override
    public List<ServicioContratado> getServiciosContratados(Evento evento) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query = session.delegate().createQuery("from ServicioContratado where evento = :evento");
            query.setParameter("evento", evento);
            List<ServicioContratado> servicioContratados = query.list();
            servicioContratados.forEach(servicioContratado -> Hibernate.initialize(servicioContratado.getEtapas()));

            return servicioContratados;
        }
        catch (HibernateException e){
            throw e;
        }
    }

}
