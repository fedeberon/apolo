package com.bolivarSoftware.apolo.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SERVICIOS")
public class Servicio {

    @Id
    @Column(name = "SER_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "SER_NOMBRE")
    private String nombre;

    @Column(name = "SER_FECHA_MAXIMA")
    private Date fechaMaximaDeFinalizacion;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PRO_ID")
    private Proveedor proveedor;

    @OneToMany(mappedBy = "servicio", fetch = FetchType.EAGER)
    private List<Etapa> etapas;

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

    public Date getFechaMaximaDeFinalizacion() {
        return fechaMaximaDeFinalizacion;
    }

    public void setFechaMaximaDeFinalizacion(Date fechaMaximaDeFinalizacion) {
        this.fechaMaximaDeFinalizacion = fechaMaximaDeFinalizacion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }

}
