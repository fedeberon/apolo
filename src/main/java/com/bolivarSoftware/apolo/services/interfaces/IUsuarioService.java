package com.bolivarSoftware.apolo.services.interfaces;

import com.bolivarSoftware.apolo.domain.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUsuarioService extends UserDetailsService {

    List<Usuario> findAll();

    List<Usuario> findAllByCreadoPor(String username);

    Usuario save(Usuario usuario);

    Usuario get(String username);

    Usuario registrar(Usuario usuario);

}
