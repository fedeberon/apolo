package com.bolivarSoftware.apolo.services.interfaces;

import com.bolivarSoftware.apolo.domain.Proveedor;
import com.bolivarSoftware.apolo.domain.ServicioContratado;

import java.util.List;

/**
 * Created by Fede Beron on 23/8/2017.
 */

public interface IServicioContratadoService extends ICommonService<ServicioContratado, Long> {
    ServicioContratado saveEtapasDelServicio(ServicioContratado servicioContratado);

     void delete (Long id);

    List<ServicioContratado> getBy(Proveedor proveedor);
}
