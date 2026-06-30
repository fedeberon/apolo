package com.bolivarSoftware.apolo.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SUGERENCIAS_CANCION")
public class SugerenciaCancion {

    @Id
    @Column(name = "SUG_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SUG_NOMBRE_CANCION", nullable = false)
    private String nombreCancion;

    @Column(name = "SUG_ARTISTA", nullable = false)
    private String artista;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SUG_FECHA")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "EVE_ID")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "USU_USERNAME")
    private Usuario sugeridoPor;

    public SugerenciaCancion() {
    }

    public SugerenciaCancion(String nombreCancion, String artista, Evento evento, Usuario sugeridoPor) {
        this.nombreCancion = nombreCancion;
        this.artista = artista;
        this.evento = evento;
        this.sugeridoPor = sugeridoPor;
        this.fecha = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Usuario getSugeridoPor() {
        return sugeridoPor;
    }

    public void setSugeridoPor(Usuario sugeridoPor) {
        this.sugeridoPor = sugeridoPor;
    }
}
