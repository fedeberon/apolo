package com.bolivarSoftware.apolo.web.usuario;

import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
