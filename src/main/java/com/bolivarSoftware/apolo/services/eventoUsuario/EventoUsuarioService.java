package com.bolivarSoftware.apolo.services.eventoUsuario;

import com.bolivarSoftware.apolo.domain.EventoUsuario;
import com.bolivarSoftware.apolo.persist.interfaces.IEventoUsuarioRepository;
import com.bolivarSoftware.apolo.services.interfaces.IEventoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian Saez on 23/5/2018.
 */
@Service
public class EventoUsuarioService implements IEventoUsuarioService{

    @Autowired
    private IEventoUsuarioRepository dao;

    @Override
    public EventoUsuario save(EventoUsuario eventoUsuario) {
        return dao.save(eventoUsuario);
    }

    @Override
    public List<EventoUsuario> findAllByUsername(String username) {
        return dao.findAllByUsername(username);
    }

    @Override
    public EventoUsuario getUltimoEventoCargado(String username) {
        List<EventoUsuario> eventoUsuarios =  dao.findAllByUsername(username);
        if(eventoUsuarios != null && eventoUsuarios.size() > 0){
            return eventoUsuarios.get(eventoUsuarios.size() - 1 );
        }
        else return null;
    }

}
