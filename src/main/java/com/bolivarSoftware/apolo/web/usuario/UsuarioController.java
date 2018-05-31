package com.bolivarSoftware.apolo.web.usuario;

import com.bolivarSoftware.apolo.domain.EventoUsuario;
import com.bolivarSoftware.apolo.domain.Rol;
import com.bolivarSoftware.apolo.domain.Servicio;
import com.bolivarSoftware.apolo.domain.Usuario;
import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @RequestMapping("list")
    public String list(Model model){
        model.addAttribute("usuarios", usuarioService.findAll());

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
    public String save(@ModelAttribute Usuario usuario) {
        usuario.setRol(new Rol(Rol.ROL_CLIENTE));
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
