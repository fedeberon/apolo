package com.bolivarSoftware.apolo.persist.usuario;

import com.bolivarSoftware.apolo.domain.Usuario;
import com.bolivarSoftware.apolo.persist.usuario.interfaces.IUsuarioRepository;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        return (Usuario) sessionFactory.getCurrentSession().get(username, Usuario.class);
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

}
