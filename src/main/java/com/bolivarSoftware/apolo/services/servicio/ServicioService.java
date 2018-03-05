package com.bolivarSoftware.apolo.services.servicio;

import com.bolivarSoftware.apolo.domain.Servicio;
import com.bolivarSoftware.apolo.persist.servicio.interfaces.IServicioRepository;
import com.bolivarSoftware.apolo.web.servicio.interfaces.IServicioService;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fede Beron on 14/7/2017.
 */
@Service
public class ServicioService implements IServicioService {

    @Autowired
    private IServicioRepository dao;

    @Override
    public Servicio get(Integer integer) {
        return dao.get(integer);
    }

    @Override
    public Servicio save(Servicio servicio) {
        return dao.save(servicio);
    }

    @Override
    public List<Servicio> findAll(){
        return dao.findAll();
    }

}
