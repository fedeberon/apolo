package com.bolivarSoftware.apolo.persist.sugerenciaCancion;

import com.bolivarSoftware.apolo.domain.SugerenciaCancion;
import com.bolivarSoftware.apolo.persist.CloseableSession;
import com.bolivarSoftware.apolo.persist.interfaces.ISugerenciaCancionRepository;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SugerenciaCancionRepository implements ISugerenciaCancionRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SugerenciaCancion save(SugerenciaCancion sugerenciaCancion) {
        Transaction tx = null;
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            tx = session.delegate().beginTransaction();
            session.delegate().saveOrUpdate(sugerenciaCancion);
            tx.commit();
            return sugerenciaCancion;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public List<SugerenciaCancion> findAllByEventoId(Integer eventoId) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("from SugerenciaCancion where evento.id = :eventoId order by fecha desc");
            query.setParameter("eventoId", eventoId);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
