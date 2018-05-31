package com.bolivarSoftware.apolo.services.interfaces;

import com.bolivarSoftware.apolo.domain.EventoUsuario;

import java.util.List;

/**
 * Created by Damian Saez on 23/5/2018.
 */

public interface IEventoUsuarioService {

    EventoUsuario save(EventoUsuario eventoUsuario);

    List<EventoUsuario> findAllByUsername(String username);

    EventoUsuario getUltimoEventoCargado(String username);

    void removeAsociacion (Integer idEvento);
}
