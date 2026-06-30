package com.bolivarSoftware.apolo.web.usuario;

import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.EventoUsuario;
import com.bolivarSoftware.apolo.domain.Rol;
import com.bolivarSoftware.apolo.domain.Usuario;
import com.bolivarSoftware.apolo.domain.UsuarioDetails;
import com.bolivarSoftware.apolo.services.interfaces.IEventoService;
import com.bolivarSoftware.apolo.services.interfaces.IEventoUsuarioService;
import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IEventoService eventoService;

    @Autowired
    private IEventoUsuarioService eventoUsuarioService;

    @RequestMapping("list")
    public String list(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth != null && auth.getPrincipal() instanceof UsuarioDetails
                ? ((UsuarioDetails) auth.getPrincipal()).getUsername() : null;
        if (username != null) {
            model.addAttribute("usuarios", usuarioService.findAllByCreadoPor(username));
        } else {
            model.addAttribute("usuarios", usuarioService.findAll());
        }

        if (auth != null && auth.getPrincipal() instanceof UsuarioDetails) {
            UsuarioDetails userDetails = (UsuarioDetails) auth.getPrincipal();
            boolean isAdmin = userDetails.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
            if (isAdmin) {
                model.addAttribute("eventos", eventoService.findAll());
            } else {
                List<EventoUsuario> eventosDeUsuario = eventoUsuarioService.findAllByUsername(username);
                List<Evento> eventos = eventosDeUsuario.stream().map(EventoUsuario::getEvento).collect(Collectors.toList());
                model.addAttribute("eventos", eventos);
            }
        }

        return "usuario/list";
    }

    @RequestMapping("create")
    public String create() {

        return "usuario/create";
    }

    @RequestMapping("show")
    public String show(@RequestParam String username, Model model) {
        model.addAttribute("usuario", usuarioService.get(username));

        return "usuario/show";
    }

    @RequestMapping("save")
    public String save(@ModelAttribute Usuario usuario, Model model) {
        if (usuarioService.get(usuario.getUsername()) != null) {
            model.addAttribute("error", "El usuario '" + usuario.getUsername() + "' ya existe");
            return "usuario/create";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsuarioDetails userDetails = (UsuarioDetails) auth.getPrincipal();
        Usuario creador = usuarioService.get(userDetails.getUsername());

        if (creador.getRol().getId() == 1L) {
            usuario.setRol(new Rol(Rol.ROL_GESTOR));
        } else {
            usuario.setRol(new Rol(Rol.ROL_CLIENTE));
        }

        usuario.setCreadoPor(creador);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioService.save(usuario);

        return "redirect:list";
    }

    @ModelAttribute("usuario")
    public Usuario getUsuario(){
        return new Usuario();
    }

    @ModelAttribute("eventoUsuario")
    public EventoUsuario eventoUsuario() {
        return new EventoUsuario();
    }

}
