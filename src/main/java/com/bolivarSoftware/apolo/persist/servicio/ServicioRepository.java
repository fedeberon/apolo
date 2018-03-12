package com.bolivarSoftware.apolo.persist.servicio;

import com.bolivarSoftware.apolo.domain.Etapa;
import com.bolivarSoftware.apolo.domain.Servicio;
import com.bolivarSoftware.apolo.persist.CloseableSession;
import com.bolivarSoftware.apolo.persist.servicio.interfaces.IServicioRepository;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ServicioRepository implements IServicioRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Servicio> findAll(){
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            return session.delegate().createQuery("from Servicio").list();
        }
        catch (HibernateException e){
            throw e;
        }
    }

    @Override
    public Servicio save(Servicio servicio) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().getTransaction();
            tx.begin();
            session.delegate().save(servicio);
            tx.commit();

            return servicio;
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }

    @Override
    public Servicio get(Integer integer) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            return (Servicio) session.delegate().get(Servicio.class, integer);
        }
        catch (HibernateException e){
            throw e;
        }
    }


    public Etapa save(Etapa etapa){
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().getTransaction();
            tx.begin();
            session.delegate().save(etapa);
            tx.commit();

            return etapa;
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }
}
