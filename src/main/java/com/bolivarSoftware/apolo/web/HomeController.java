package com.bolivarSoftware.apolo.web;

import com.bolivarSoftware.apolo.domain.EtapaARealizar;
import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.services.interfaces.IEtapaService;
import com.bolivarSoftware.apolo.services.interfaces.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private IEventoService eventoService;

    @Autowired
    private IEtapaService etapaService;

    @RequestMapping(value = {"/home", "/"})
    public String index(){
        return "index";
    }

    @RequestMapping(value = {"/login" ,"logout-success"} )
    public String login(){
        return "login";
    }

    @ModelAttribute("eventosProximos")
    private List<Evento> eventosProximos(){
        return eventoService.findAllPageable(1);
    }

    @ModelAttribute("tareasProximas")
    private List<EtapaARealizar> tareasProximas(){
        return etapaService.tareasProximas();
    }

}
