package com.bolivarSoftware.apolo.services.interfaces;

import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.ServicioContratado;

import java.util.List;

/**
 * Created by Fede Beron on 8/8/2017.
 */
public interface IEventoService extends ICommonService<Evento, Integer>{

    List<ServicioContratado> getServiciosContratados(Evento evento);

    List<Evento> findAllPageable(Integer page);
}
