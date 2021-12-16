package com.bolivarSoftware.apolo.web;

import com.bolivarSoftware.apolo.domain.EtapaARealizar;
import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.EventoUsuario;
import com.bolivarSoftware.apolo.services.interfaces.IEtapaService;
import com.bolivarSoftware.apolo.services.interfaces.IEventoService;
import com.bolivarSoftware.apolo.services.interfaces.IEventoUsuarioService;
import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    private IEventoService eventoService;
    private IEtapaService etapaService;
    private IUsuarioService usuarioService;
    private IEventoUsuarioService eventoUsuarioService;

    @Autowired
    public HomeController(final IEventoService eventoService,
                          final IEtapaService etapaService,
                          final IUsuarioService usuarioService,
                          final IEventoUsuarioService eventoUsuarioService) {
        this.eventoService = eventoService;
        this.etapaService = etapaService;
        this.usuarioService = usuarioService;
        this.eventoUsuarioService = eventoUsuarioService;
    }

    @RequestMapping(value = {"/home", "/"})
    public String index(Model modal){
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            return "welcome";
        }
        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (containRol(user.getAuthorities(), "ADMIN")) {
            return "index";
        } if (containRol(user.getAuthorities(), "USER")) {
            return "usuario/bienvenida-evento";
        } else {
            return "index";
        }
    }

    private boolean containRol(Collection<GrantedAuthority> roles, final String rol) {
        for(GrantedAuthority role : roles) {
            if (role.getAuthority().equals("ROLE_".concat(rol))) {
                return true;
            }
        }
        return false;
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
        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        EventoUsuario eventoUsuario = eventoUsuarioService.getUltimoEventoCargado(user.getUsername());
        if(eventoUsuario == null) {
            return "redirect:home";
        } else {
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
