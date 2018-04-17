package com.bolivarSoftware.apolo.persist.interfaces;

import com.bolivarSoftware.apolo.domain.Event;

import java.util.List;

/**
 * Created by Damian Saez on 23/3/2018.
 */
public interface IAgendaRepository {
    void saveEvent(Event event);

    List<Event> findAll();
}
