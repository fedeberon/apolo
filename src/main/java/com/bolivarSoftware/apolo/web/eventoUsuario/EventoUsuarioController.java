package com.bolivarSoftware.apolo.web.eventoUsuario;

import com.bolivarSoftware.apolo.beans.RedirectAuthentication;
import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.EventoUsuario;
import com.bolivarSoftware.apolo.services.interfaces.IEventoService;
import com.bolivarSoftware.apolo.services.interfaces.IEventoUsuarioService;
import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by Damian Saez on 23/5/2018.
 */

@Controller
@RequestMapping("eventoUsuario")
public class EventoUsuarioController {

    @Autowired
    private IEventoUsuarioService eventoUsuarioService;

    @Autowired
    private IEventoService eventoService;

  @RequestMapping("save")
    public String save(@ModelAttribute EventoUsuario eventoUsuario, RedirectAttributes redirectAttributes){
      Evento evento = eventoService.get(eventoUsuario.getEvento().getId());
      if(evento == null) return "redirect:usuario/list";
      eventoUsuarioService.save(eventoUsuario);
      redirectAttributes.addAttribute("username", eventoUsuario.getUsuario().getUsername());

      return "redirect:/usuario/show";
    }

    @RequestMapping(value = "show")
    public String show(@RequestParam String username, Model model) {
        List<EventoUsuario> eventosDeUsuario = eventoUsuarioService.findAllByUsername(username);
        model.addAttribute("eventosDeUsuario", eventosDeUsuario);

        return "eventoUsuario/show";
    }



    @ModelAttribute("eventoUsuario")
    public EventoUsuario eventoUsuario() {
        return new EventoUsuario();
    }

}



