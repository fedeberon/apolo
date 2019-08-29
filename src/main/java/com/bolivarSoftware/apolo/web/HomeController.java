package com.bolivarSoftware.apolo.web;

import com.bolivarSoftware.apolo.domain.EtapaARealizar;
import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.EventoUsuario;
import com.bolivarSoftware.apolo.domain.Usuario;
import com.bolivarSoftware.apolo.services.interfaces.IEtapaService;
import com.bolivarSoftware.apolo.services.interfaces.IEventoService;
import com.bolivarSoftware.apolo.services.interfaces.IEventoUsuarioService;
import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    @Autowired
    private IEventoUsuarioService eventoUsuarioService;

    @RequestMapping(value = {"/home", "/"})
    public String index(){

        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            return "welcome";
        }

        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (usuario.getRol().getId() == 1){
            return "index";
        }

        else return "redirect:bienvenida";

    }

    @RequestMapping(value = {"/login" ,"logout-success"} )
    public String login(){
        return "login";
    }

    @RequestMapping(value = {"/welcome"} )
    public String welcome(){
        return "welcome";
    }

    @RequestMapping(value = {"/bienvenida"} )
    public String bienvenida(Model modal){
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        EventoUsuario eventoUsuario = eventoUsuarioService.getUltimoEventoCargado(usuario.getUsername());

        if(eventoUsuario == null){
            return "redirect:home";
        }

        else {
            modal.addAttribute("evento", eventoUsuario.getEvento());
            return "usuario/bienvenida-evento";
        }
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
