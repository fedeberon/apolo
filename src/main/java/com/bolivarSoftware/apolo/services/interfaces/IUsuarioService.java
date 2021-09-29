package com.bolivarSoftware.apolo.services.interfaces;

import com.bolivarSoftware.apolo.domain.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by Damian on 07/03/2018.
 */
public interface IUsuarioService extends UserDetailsService {

    List<Usuario> findAll();

    Usuario save(Usuario usuario);

    Usuario get(String username);

}
