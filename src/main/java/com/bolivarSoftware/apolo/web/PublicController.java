package com.bolivarSoftware.apolo.web;

import com.bolivarSoftware.apolo.domain.Usuario;
import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicController {

    @Autowired
    private IUsuarioService usuarioService;

    @RequestMapping("/registro")
    public String registro() {
        return "registro";
    }

    @RequestMapping("/guardarRegistro")
    public String guardarRegistro(@ModelAttribute Usuario usuario, Model model) {
        if (usuarioService.get(usuario.getUsername()) != null) {
            model.addAttribute("error", "El usuario '" + usuario.getUsername() + "' ya existe");
            return "registro";
        }
        usuarioService.registrar(usuario);
        return "redirect:/login";
    }
}