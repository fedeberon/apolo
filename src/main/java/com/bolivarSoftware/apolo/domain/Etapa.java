package com.bolivarSoftware.apolo.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Fede Beron on 14/7/2017.
 */
@Entity
@Table(name = "ETAPAS")
public class Etapa {

    @Id
    @Column(name = "ETA_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "ETA_NOMBRE  ")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "ETA_SER_ID")
    private Servicio servicio;

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

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
