package com.bolivarSoftware.apolo.config;

import com.bolivarSoftware.apolo.domain.Rol;
import com.bolivarSoftware.apolo.domain.Usuario;
import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SessionFactory sessionFactory;

    @PostConstruct
    public void init() {
        Session session = sessionFactory.openSession();
        try {
            Rol existing = (Rol) session.get(Rol.class, 4L);
            if (existing == null) {
                Transaction tx = session.beginTransaction();
                Rol gestorRol = new Rol();
                gestorRol.setId(4L);
                gestorRol.setNombre("GESTOR");
                session.save(gestorRol);
                tx.commit();
            }
        } finally {
            session.close();
        }

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
