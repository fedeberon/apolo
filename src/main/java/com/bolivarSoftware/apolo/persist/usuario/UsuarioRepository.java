package com.bolivarSoftware.apolo.persist.usuario;

import com.bolivarSoftware.apolo.domain.Usuario;
import com.bolivarSoftware.apolo.persist.CloseableSession;
import com.bolivarSoftware.apolo.persist.usuario.interfaces.IUsuarioRepository;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Damian on 07/03/2018.
 */
@Repository
public class UsuarioRepository implements IUsuarioRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Usuario get(String username){
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            return (Usuario) session.delegate().get(Usuario.class, username);

        } catch (HibernateException e) {

            throw e;
        }
    }

    @Override
    public List<Usuario> findAll(){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Usuario");

            return query.list();
        }
        catch (HibernateException e){
            e.printStackTrace();
            throw e;
        }

        finally {
            if(session!= null && session.isOpen()) session.close();
        }

    }

    @Override
    public Usuario save(Usuario usuario) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().beginTransaction();
            session.delegate().saveOrUpdate(usuario);
            tx.commit();

            return usuario;
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }

}
