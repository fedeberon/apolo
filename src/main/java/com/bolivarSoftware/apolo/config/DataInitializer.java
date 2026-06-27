package com.bolivarSoftware.apolo.config;

import com.bolivarSoftware.apolo.domain.Rol;
import com.bolivarSoftware.apolo.domain.Usuario;
import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (usuarioService.get("admin") == null) {
            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setNombre("Admin");
            admin.setApellido("Sistema");
            Rol rolAdmin = new Rol();
            rolAdmin.setId(1L);
            admin.setRol(rolAdmin);
            usuarioService.save(admin);
        }
    }
}