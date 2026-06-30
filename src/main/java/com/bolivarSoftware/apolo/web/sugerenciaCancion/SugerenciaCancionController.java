package com.bolivarSoftware.apolo.web.sugerenciaCancion;

import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.SugerenciaCancion;
import com.bolivarSoftware.apolo.domain.Usuario;
import com.bolivarSoftware.apolo.domain.UsuarioDetails;
import com.bolivarSoftware.apolo.services.interfaces.IEventoService;
import com.bolivarSoftware.apolo.services.interfaces.ISugerenciaCancionService;
import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("sugerenciaCancion")
public class SugerenciaCancionController {

    @Autowired
    private ISugerenciaCancionService sugerenciaCancionService;

    @Autowired
    private IEventoService eventoService;

    @Autowired
    private IUsuarioService usuarioService;

    @RequestMapping("save")
    public String save(@RequestParam Integer eventoId,
                       @RequestParam String nombreCancion,
                       @RequestParam String artista) {
        Evento evento = eventoService.get(eventoId);
        if (evento == null) return "redirect:/bienvenida";

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UsuarioDetails) {
            UsuarioDetails userDetails = (UsuarioDetails) auth.getPrincipal();
            Usuario usuario = usuarioService.get(userDetails.getUsername());
            if (usuario != null) {
                SugerenciaCancion sugerencia = new SugerenciaCancion(nombreCancion, artista, evento, usuario);
                sugerenciaCancionService.save(sugerencia);
            }
        }

        return "redirect:/bienvenida";
    }
}
