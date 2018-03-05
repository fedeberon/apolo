package com.bolivarSoftware.apolo.persist.servicio.interfaces;

import com.bolivarSoftware.apolo.domain.Servicio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Fede Beron on 14/7/2017.
 */
public interface IServicioRepository {

    List<Servicio> findAll();

    Servicio save(Servicio servicio);

    Servicio get(Integer integer);
}
