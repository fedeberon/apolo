package com.bolivarSoftware.apolo.services.usuario;

import com.bolivarSoftware.apolo.domain.Rol;
import com.bolivarSoftware.apolo.domain.Usuario;
import com.bolivarSoftware.apolo.persist.usuario.interfaces.IUsuarioRepository;
import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = dao.get(username);
        if(Objects.isNull(usuario)) throw new UsernameNotFoundException("User not authorized.");

        return new com.bolivarSoftware.apolo.domain.UsuarioDetails(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Usuario> findAllByCreadoPor(String username) {
        return dao.findAllByCreadoPor(username);
    }

    @Override
    public Usuario save(Usuario usuario) {
        if(usuario.getRol() == null) {
            usuario.setRol(new Rol(Rol.ROL_CLIENTE));
        }
        return dao.save(usuario);
    }

    @Override
    public Usuario get(String username) {
        return dao.get(username);
    }

    @Override
    public Usuario registrar(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRol(new Rol(Rol.ROL_CLIENTE));
        return dao.save(usuario);
    }

}
