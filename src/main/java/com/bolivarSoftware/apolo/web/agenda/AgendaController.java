package com.bolivarSoftware.apolo.web.agenda;

import com.bolivarSoftware.apolo.services.interfaces.IAgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Damian on 19/03/2018.
 */

@Controller
@RequestMapping("agenda")
public class AgendaController {


    @Autowired
    private IAgendaService agendaService;

    @RequestMapping("show")
    public String show(){

        return "agenda/show";
    }


    @RequestMapping("create")
    public String create(@RequestParam String titulo, @RequestParam String inicio, @RequestParam String fin ){
        agendaService.save(titulo, inicio, fin);

        return "redirect:show";
    }

}
