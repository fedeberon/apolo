package com.bolivarSoftware.apolo.domain;

import javax.persistence.*;

/**
 * Created by Damian Saez on 21/5/2018.
 */
@Entity
@Table(name = "PERMISOS")
public class Permiso {

    @Id
    @Column(name = "PER_ID")
    private Long id;

    @Column(name = "PER_NOMBRE")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "PER_ROL_ID")
    private Rol rol;

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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}