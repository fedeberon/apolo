package com.bolivarSoftware.apolo.domain;

import javax.persistence.*;

/**
 * Created by Damian Saez on 22/5/2018.
 */

@Entity
@Table(name = "EVENTO_USUARIOS")
public class EventoUsuario {

    @Id
    @Column(name = "EVE_USU_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "EVE_USU_USU_ID")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "EVE_USU_EVE_ID")
    private Evento evento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
