package com.bolivarSoftware.apolo.persist.etapa;

import com.bolivarSoftware.apolo.domain.EtapaARealizar;
import com.bolivarSoftware.apolo.domain.ServicioContratado;
import com.bolivarSoftware.apolo.persist.CloseableSession;
import com.bolivarSoftware.apolo.persist.interfaces.IEtapaARealizarRepository;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Damian on 12/03/2018.
 */
@Repository
public class EtapaARealizarRepository implements IEtapaARealizarRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void remove(Long id) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().getTransaction();
            tx.begin();
            EtapaARealizar etapaARealizar = (EtapaARealizar) session.delegate().get(EtapaARealizar.class, id);
            session.delegate().delete(etapaARealizar);
            tx.commit();
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }
}
