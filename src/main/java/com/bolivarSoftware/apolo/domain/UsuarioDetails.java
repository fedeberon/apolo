package com.bolivarSoftware.apolo.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsuarioDetails extends User {

    private String nombre;
    private String apellido;

    public UsuarioDetails(Usuario usuario) {
        super(usuario.getUsername(), usuario.getPassword(), getAuthoritiesFromRol(usuario));
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
    }

    private static Collection<? extends GrantedAuthority> getAuthoritiesFromRol(Usuario usuario) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (usuario.getRol() != null && usuario.getRol().getNombre() != null) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().getNombre()));
        }
        return authorities;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}