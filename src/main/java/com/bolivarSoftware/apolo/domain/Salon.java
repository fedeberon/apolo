package com.bolivarSoftware.apolo.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Damian on 15/03/2018.
 */

@Entity
@Table(name = "SALONES")
public class Salon {

    @Id
    @Column(name = "SAL_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "SAL_NOMBRE")
    private String nombre;

    @Column(name ="SAL_DIRECCION")
    private String direccion;

    @Column(name = "SAL_COMENTARIO")
    private String comentario;

    @Column(name = "SAL_DESCRIPCION")
    private String descripcion;

    @Column(name = "SAL_EMAIL")
    private String email;

    @Column(name = "SAL_TELEFONO")
    private String telefono;

    @Transient
    private List<Imagen> imagenes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
