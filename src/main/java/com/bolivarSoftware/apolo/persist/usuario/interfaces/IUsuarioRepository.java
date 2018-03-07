package com.bolivarSoftware.apolo.persist.usuario.interfaces;

import com.bolivarSoftware.apolo.domain.Usuario;

import java.util.List;

/**
 * Created by Damian on 07/03/2018.
 */
public interface IUsuarioRepository {
    Usuario get(String username);

    List<Usuario> findAll();
}
