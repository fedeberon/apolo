package com.bolivarSoftware.apolo.persist.agenda;

import com.bolivarSoftware.apolo.domain.Event;
import com.bolivarSoftware.apolo.persist.CloseableSession;
import com.bolivarSoftware.apolo.persist.interfaces.IAgendaRepository;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Damian Saez on 23/3/2018.
 */

@Repository
public class AgendaRepository implements IAgendaRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveEvent(Event event) {
        Transaction tx = null;
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            tx = session.delegate().beginTransaction();
            session.delegate().save(event);
            tx.commit();

        } catch (HibernateException e) {
            tx.rollback();
            throw e;
        }
    }

    @Override
    public List<Event> findAll() {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("from Event");

            return query.list();
        } catch (HibernateException e) {
            throw e;
        }
    }
}