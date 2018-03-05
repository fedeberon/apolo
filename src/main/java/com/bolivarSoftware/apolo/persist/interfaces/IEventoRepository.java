package com.bolivarSoftware.apolo.persist.interfaces;

import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.ServicioContratado;

import java.util.List;

/**
 * Created by Fede Beron on 8/8/2017.
 */
public interface IEventoRepository {
    Evento save(Evento evento);

    List<Evento> findAll();

    Evento get(Integer integer);

    List<ServicioContratado> getServiciosContratados(Evento evento);

    List<Evento> findAllPageable(Integer page);
}
