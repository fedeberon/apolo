package com.bolivarSoftware.apolo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PROVEEDORES")
public class Proveedor {

    @Id
    @Column(name = "PRO_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "PRO_NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "proveedor")
    private List<Servicio> servicios;

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

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}
