package com.bolivarSoftware.apolo.web.servicio.interfaces;

import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.Servicio;
import com.bolivarSoftware.apolo.services.interfaces.ICommonService;

import java.util.List;

/**
 * Created by Fede Beron on 14/7/2017.
 */
public interface IServicioService extends ICommonService<Servicio, Integer>{
    List<Servicio> findAll(Evento evento);
}
