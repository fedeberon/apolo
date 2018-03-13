package com.bolivarSoftware.apolo.persist.interfaces;

import com.bolivarSoftware.apolo.domain.Proveedor;
import com.bolivarSoftware.apolo.domain.ServicioContratado;

import java.util.List;

/**
 * Created by Fede Beron on 8/8/2017.
 */
public interface IServicioContratadoRepository  {
    ServicioContratado save(ServicioContratado servicio);

    List<ServicioContratado> save(List<ServicioContratado> servicio);

    ServicioContratado get(Long aLong);

    List<ServicioContratado> findAll();

    ServicioContratado saveEtapasDelServicio(ServicioContratado servicio);

    void remove(Long id);

    List<ServicioContratado> getBy(Proveedor proveedor);
}
