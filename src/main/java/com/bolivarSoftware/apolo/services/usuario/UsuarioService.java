package com.bolivarSoftware.apolo.services.usuario;

import com.bolivarSoftware.apolo.domain.Usuario;
import com.bolivarSoftware.apolo.persist.usuario.interfaces.IUsuarioRepository;
import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian on 07/03/2018.
 */
@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return dao.get(username);
    }

    @Override
    public List<Usuario> findAll() {
        return dao.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return dao.save(usuario);
    }


}
