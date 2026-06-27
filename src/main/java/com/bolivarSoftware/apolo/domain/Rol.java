package com.bolivarSoftware.apolo.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Damian Saez on 21/5/2018.
 */
@Entity
@Table(name = "ROLES")
public class Rol {

    public static Long ROL_CLIENTE = 2l;

    @Id
    @Column(name = "ROL_ID")
    private Long id;

    @Column(name = "ROL_NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "rol", fetch = FetchType.EAGER)
    private List<Permiso> permisos;

    public Rol() {
    }

    public Rol(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }


}
