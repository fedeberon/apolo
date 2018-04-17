package com.bolivarSoftware.apolo.services.agenda;

import com.bolivarSoftware.apolo.domain.Event;
import com.bolivarSoftware.apolo.persist.interfaces.IAgendaRepository;
import com.bolivarSoftware.apolo.services.interfaces.IAgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Damian Saez on 23/3/2018.
 */

@Service
public class AgendaService implements IAgendaService {

    @Autowired
    private IAgendaRepository dao;

    @Override
    public void save(String titulo, String inicio, String fin) {
        Event event = null;
        try {
            event = new Event(titulo, inicio, fin);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        dao.saveEvent(event);
    }

    @Override
    public List<Event> findAll() {
        return dao.findAll();
    }

}
