package com.bolivarSoftware.apolo.persist.eventoUsuario;

import com.bolivarSoftware.apolo.domain.EventoUsuario;
import com.bolivarSoftware.apolo.persist.CloseableSession;
import com.bolivarSoftware.apolo.persist.interfaces.IEventoUsuarioRepository;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Damian Saez on 23/5/2018.
 */

@Repository
public class EventoUsuarioRepository implements IEventoUsuarioRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public EventoUsuario save(EventoUsuario eventoUsuario) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().beginTransaction();
            session.delegate().saveOrUpdate(eventoUsuario);
            tx.commit();

            return eventoUsuario;
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }

    @Override
    public List<EventoUsuario> findAllByUsername(String username) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query =  session.delegate().createQuery("from EventoUsuario where usuario.username = :username");
            query.setParameter("username", username);

            return query.list();
        }
        catch (HibernateException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void removeAsociacion(Integer idEvento) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query =  session.delegate().createQuery("delete from EventoUsuario where evento.id = :idEvento");
            query.setParameter("idEvento", idEvento);
            query.executeUpdate();
        }
        catch (HibernateException e){
            e.printStackTrace();
            throw e;
        }
    }


}
