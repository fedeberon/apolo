package com.bolivarSoftware.apolo.services.interfaces;

import com.bolivarSoftware.apolo.domain.ServicioContratado;

/**
 * Created by Fede Beron on 23/8/2017.
 */

public interface IServicioContratadoService extends ICommonService<ServicioContratado, Long> {
    ServicioContratado saveEtapasDelServicio(ServicioContratado servicioContratado);
}
