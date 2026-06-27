package com.bolivarSoftware.apolo.services.interfaces;

import com.bolivarSoftware.apolo.domain.Event;

import java.util.List;

/**
 * Created by Damian Saez on 23/3/2018.
 */
public interface IAgendaService {
    void save(String titulo, String inicio, String fin, String descripcion);

    List<Event> findAll();
}
