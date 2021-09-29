package com.bolivarSoftware.apolo.util;

import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrentAuthentication {

    private IUsuarioService usuarioService;

    @Autowired
    public CurrentAuthentication(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

}
