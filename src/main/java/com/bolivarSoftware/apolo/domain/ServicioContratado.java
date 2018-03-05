package com.bolivarSoftware.apolo.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Fede Beron on 8/8/2017.
 */

@Entity
@Table(name = "SERVICIOS_CONTRATADOS")
public class ServicioContratado {

    @Id
    @Column(name = "SEC_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SEC_SER_ID")
    private Servicio servicio;

    @OneToMany(cascade = { CascadeType.PERSIST , CascadeType.MERGE, CascadeType.REFRESH} , mappedBy = "servicioContratado", fetch = FetchType.LAZY)
    private List<EtapaARealizar> etapas;

    @ManyToOne
    @JoinColumn(name = "SEC_EVE_ID")
    private Evento evento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<EtapaARealizar> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<EtapaARealizar> etapas) {
        this.etapas = etapas;
    }

    public long getPorcentajeCompletado(){
        long cantidadDeEtapas = etapas.stream().count();
        long cantidaDeEtapasResueltas = etapas.stream().filter(etapa -> etapa.getCompletada() == true).count();
        if(cantidaDeEtapasResueltas == 0 ) return cantidaDeEtapasResueltas;
        Double result = Double.valueOf(cantidaDeEtapasResueltas) * 100 /  Double.valueOf(cantidadDeEtapas);

        return Math.round(result);
    }
}
