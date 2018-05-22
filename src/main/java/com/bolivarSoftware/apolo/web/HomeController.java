package com.bolivarSoftware.apolo.web;

import com.bolivarSoftware.apolo.domain.EtapaARealizar;
import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.Usuario;
import com.bolivarSoftware.apolo.services.interfaces.IEtapaService;
import com.bolivarSoftware.apolo.services.interfaces.IEventoService;
import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private IEventoService eventoService;

    @Autowired
    private IEtapaService etapaService;

    @Autowired
    private IUsuarioService usuarioService;

    @RequestMapping(value = {"/home", "/"})
    public String index(){
        return "index";
    }

    @RequestMapping(value = {"/login" ,"logout-success"} )
    public String login(){
        return "login";
    }

    @RequestMapping(value = {"/bienvenida"} )
    public String bienvenida(){
        return "bienvenida-evento";
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
