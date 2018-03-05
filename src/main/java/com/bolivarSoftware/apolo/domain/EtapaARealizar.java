package com.bolivarSoftware.apolo.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Fede Beron on 19/8/2017.
 */
@Entity
@Table(name = "etapaARealizar")
public class EtapaARealizar {

    @Id
    @Column(name = "ETR_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ETR_ETA_ID")
    private Etapa etapa;

    @Column(name = "ETR_COMPLETADA")
    private Boolean completada = false;

    @ManyToOne
    @JoinColumn(name = "ETR_ETR_ID")
    private ServicioContratado servicioContratado;

    @Column(name = "ETA_FECHA")
    private LocalDateTime fecha;

    @Column(name = "ETR_PESO_ESPECIFICO")
    private Integer pesoEspecifico;

    @Column(name = "ETR_CANT_DIAS_LIMITE")
    private Integer cantidadDiasLimiteDeResolucion;

    public EtapaARealizar() {
    }

    public EtapaARealizar(Etapa etapa, ServicioContratado servicioContratado) {
        this.etapa = etapa;
        this.servicioContratado = servicioContratado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public Boolean getCompletada() {
        return completada;
    }

    public void setCompletada(Boolean completada) {
        this.completada = completada;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public ServicioContratado getServicioContratado() {
        return servicioContratado;
    }

    public void setServicioContratado(ServicioContratado servicioContratado) {
        this.servicioContratado = servicioContratado;
    }

    public Integer getPesoEspecifico() {
        return pesoEspecifico;
    }

    public void setPesoEspecifico(Integer pesoEspecifico) {
        this.pesoEspecifico = pesoEspecifico;
    }

    public Integer getCantidadDiasLimiteDeResolucion() {
        return cantidadDiasLimiteDeResolucion;
    }

    public void setCantidadDiasLimiteDeResolucion(Integer cantidadDiasLimiteDeResolucion) {
        this.cantidadDiasLimiteDeResolucion = cantidadDiasLimiteDeResolucion;
    }
}
