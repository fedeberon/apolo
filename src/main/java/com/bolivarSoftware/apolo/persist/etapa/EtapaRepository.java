package com.bolivarSoftware.apolo.persist.etapa;

import com.bolivarSoftware.apolo.beans.Pagination;
import com.bolivarSoftware.apolo.domain.Etapa;
import com.bolivarSoftware.apolo.domain.EtapaARealizar;
import com.bolivarSoftware.apolo.persist.CloseableSession;
import com.bolivarSoftware.apolo.persist.interfaces.IEtapaRepository;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Fede Beron on 31/7/2017.
 */
@Repository
public class EtapaRepository implements IEtapaRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Etapa save(Etapa etapa) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            session.delegate().saveOrUpdate(etapa);

            return etapa;
        }
        catch (HibernateException e){
            throw e;
        }
    }

    @Override
    public List<EtapaARealizar> tareasProximas() {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query = session.delegate().createQuery("from EtapaARealizar where completada = false order by fecha asc, pesoEspecifico desc");
            query.setFirstResult(Pagination.ONE_ROW);
            query.setMaxResults(Pagination.MAX_PAGE);

            return query.list();
        }
        catch (HibernateException e){
            throw e;
        }
    }

    @Override
    public List<EtapaARealizar> tareasProximasByUsername(String username) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query = session.delegate().createQuery(
                "select ear from EtapaARealizar ear " +
                "where ear.completada = false and ear.servicioContratado.evento.id in " +
                "(select eu.evento.id from EventoUsuario eu where eu.usuario.username = :username) " +
                "order by ear.fecha asc, ear.pesoEspecifico desc");
            query.setParameter("username", username);
            query.setFirstResult(Pagination.ONE_ROW);
            query.setMaxResults(Pagination.MAX_PAGE);

            return query.list();
        }
        catch (HibernateException e){
            throw e;
        }
    }
}