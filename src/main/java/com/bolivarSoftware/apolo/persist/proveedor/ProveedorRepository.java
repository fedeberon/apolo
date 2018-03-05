package com.bolivarSoftware.apolo.persist.proveedor;

import com.bolivarSoftware.apolo.domain.Proveedor;
import com.bolivarSoftware.apolo.persist.CloseableSession;
import com.bolivarSoftware.apolo.persist.interfaces.IProveedorRepository;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProveedorRepository implements IProveedorRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Proveedor get(Integer id) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            return (Proveedor) session.delegate().get(Proveedor.class, id);
        }
        catch (HibernateException e){
            throw e;
        }
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            session.delegate().saveOrUpdate(proveedor);

            return proveedor;
        }
        catch (HibernateException e){
            throw e;
        }
    }

    @Override
    public List<Proveedor> findAll() {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            return session.delegate().createQuery("from Proveedor").list();
        }
        catch (HibernateException e){
            throw e;
        }
    }
}
