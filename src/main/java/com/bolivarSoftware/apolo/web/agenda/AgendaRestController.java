package com.bolivarSoftware.apolo.web.agenda;

import com.bolivarSoftware.apolo.domain.Event;
import com.bolivarSoftware.apolo.services.interfaces.IAgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Damian Saez on 17/4/2018.
 */
@RestController
@RequestMapping("agendaRest")
public class AgendaRestController {

    @Autowired
    private IAgendaService agendaService;

    @RequestMapping("events")
    public @ResponseBody List<Event> getEventos(){
        return agendaService.findAll();
    }

    @RequestMapping("save")
    public void save(@RequestParam String title, @RequestParam String startdate, @RequestParam String descripcion) throws Exception{
        agendaService.save(title, startdate, "2018-04-17", descripcion);
    }




}
