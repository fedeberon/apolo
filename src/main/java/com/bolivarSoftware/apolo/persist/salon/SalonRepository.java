package com.bolivarSoftware.apolo.persist.salon;

import com.bolivarSoftware.apolo.beans.Pagination;
import com.bolivarSoftware.apolo.domain.Salon;
import com.bolivarSoftware.apolo.persist.CloseableSession;
import com.bolivarSoftware.apolo.persist.interfaces.ISalonRepository;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Damian on 15/03/2018.
 */

@Repository
public class SalonRepository implements ISalonRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Salon save(Salon salon) {
        Transaction tx = null;
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            tx = session.delegate().beginTransaction();
            session.delegate().saveOrUpdate(salon);
            tx.commit();

            return salon;

        } catch (HibernateException e) {
            tx.rollback();
            throw e;
        }
    }

    @Override
    public List<Salon> findAll() {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            return session.delegate().createQuery("from Salon").list();
        } catch (HibernateException e) {
            throw e;
        }
    }

    @Override
    public List<Salon> findAllPageable(Integer pageNumber) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("from Salon");
            query.setFirstResult((pageNumber - 1) * Pagination.MAX_PAGE);
            query.setMaxResults(Pagination.MAX_PAGE);

            return query.list();
        } catch (HibernateException e) {
            throw e;
        }
    }

    @Override
    public Salon get(Integer integer) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Salon salon = (Salon) session.delegate().get(Salon.class, integer);

            return salon;
        }
        catch (HibernateException e){
            throw e;
        }
    }

}


