package com.bolivarSoftware.apolo.persist.interfaces;

import com.bolivarSoftware.apolo.domain.EventoUsuario;

import java.util.List;

/**
 * Created by Damian Saez on 23/5/2018.
 */
public interface IEventoUsuarioRepository {

    EventoUsuario save(EventoUsuario eventoUsuario);

    List<EventoUsuario> findAllByUsername(String username);
}
