package com.bolivarSoftware.apolo.persist.servicioContratado;

import com.bolivarSoftware.apolo.domain.EtapaARealizar;
import com.bolivarSoftware.apolo.domain.ServicioContratado;
import com.bolivarSoftware.apolo.persist.CloseableSession;
import com.bolivarSoftware.apolo.persist.interfaces.IServicioContratadoRepository;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServicioContratadoRepository implements IServicioContratadoRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public ServicioContratado save(ServicioContratado servicio) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().getTransaction();
            tx.begin();
            session.delegate().saveOrUpdate(servicio);
            tx.commit();

            return servicio;
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }

    @Override
    public List<ServicioContratado> save(List<ServicioContratado> servicio) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().getTransaction();
            tx.begin();
            servicio.forEach(servicioContratado -> session.delegate().save(servicio));
            tx.commit();

            return servicio;
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }

    @Override
    public ServicioContratado get(Long aLong) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            ServicioContratado servicioContratado = (ServicioContratado) session.delegate().get(ServicioContratado.class, aLong);
            Hibernate.initialize(servicioContratado.getEtapas());

            return servicioContratado;
        }
        catch (HibernateException e){
            throw e;
        }
    }

    @Override
    public List<ServicioContratado> findAll() {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query = session.delegate().createQuery("from ServicioContratado");

            return query.list();
        }
        catch (HibernateException e){
            throw e;
        }
    }


    @Override
    public ServicioContratado saveEtapasDelServicio(ServicioContratado servicio) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().getTransaction();
            tx.begin();
            servicio.getEtapas().forEach(etapaARealizar -> session.delegate().saveOrUpdate(etapaARealizar));
            session.delegate().update(servicio);
            tx.commit();

            return servicio;
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }

    @Override
    public void remove(Long id) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().getTransaction();
            tx.begin();
            ServicioContratado servicioContratado = (ServicioContratado) session.delegate().get(ServicioContratado.class, id);
            Hibernate.initialize(servicioContratado.getEtapas());
            servicioContratado.getEtapas().forEach(etapaARealizar -> session.delegate().delete(etapaARealizar));
            session.delegate().delete(servicioContratado);
            tx.commit();
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }

}
