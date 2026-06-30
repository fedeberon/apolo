package com.bolivarSoftware.apolo.domain;

import com.bolivarSoftware.apolo.beans.TipoDeEvento;
import com.bolivarSoftware.apolo.domain.Servicio;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EVENTOS")
public class Evento {

    @Id
    @Column(name = "EVE_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "EVE_NOMBRE")
    private String nombre;

    @Column(name = "EVE_CIUDAD")
    private String ciudad;

    @Column(name = "EVE_DOMICILIO")
    private String domicilio;

    @Column(name = "EVE_TELEFONO")
    private String telefono;

    @Column(name = "EVE_MAIL")
    private String mail;

    @Column(name = "EVE_LULAR")
    private String lugar;

    @Column(name = "EVE_FECHA_EVENTO")
    private Date fechaDeEvento;

    @Column(name = "EVE_CONTRATADO_POR")
    private String contratadoPor;

    @Column(name = "EVE_LATITUD")
    private BigDecimal latitud;

    @Column(name = "EVE_LONGITUD")
    private BigDecimal longitud;

    @Enumerated(EnumType.STRING)
    @Column(name = "EVE_TIPO")
    private TipoDeEvento tipoDeEvento;

    @OneToMany(cascade =  { CascadeType.PERSIST}, mappedBy = "evento")
    private List<ServicioContratado> servicios = new ArrayList<>();

    @Column(name = "EVE_PLAYLIST")
    private String playlist;

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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getFechaDeEvento() {
        return fechaDeEvento;
    }

    public void setFechaDeEvento(Date fechaDeEvento) {
        this.fechaDeEvento = fechaDeEvento;
    }

    public String getContratadoPor() {
        return contratadoPor;
    }

    public void setContratadoPor(String contratadoPor) {
        this.contratadoPor = contratadoPor;
    }

    public TipoDeEvento getTipoDeEvento() {
        return tipoDeEvento;
    }

    public void setTipoDeEvento(TipoDeEvento tipoDeEvento) {
        this.tipoDeEvento = tipoDeEvento;
    }

    public List<ServicioContratado> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioContratado> servicios) {
        this.servicios = servicios;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public String getPlaylist() {
        return playlist;
    }

    public void setPlaylist(String playlist) {
        this.playlist = normalizePlaylist(playlist);
    }

    private String normalizePlaylist(String value) {
        if (value == null || value.trim().isEmpty()) return null;
        value = value.trim();
        if (value.startsWith("https://open.spotify.com/playlist/")) {
            String id = value.substring("https://open.spotify.com/playlist/".length());
            int q = id.indexOf('?');
            if (q >= 0) id = id.substring(0, q);
            return "playlist:" + id;
        }
        if (value.startsWith("spotify:playlist:")) {
            return "playlist:" + value.substring("spotify:playlist:".length());
        }
        if (value.startsWith("playlist:")) {
            return value;
        }
        return "playlist:" + value;
    }

    public String getPlaylistWebUrl() {
        if (playlist == null || playlist.isEmpty()) return null;
        String id = playlist;
        int idx = id.lastIndexOf(':');
        if (idx >= 0) id = id.substring(idx + 1);
        return "https://open.spotify.com/playlist/" + id;
    }
}
