package com.bolivarSoftware.apolo.services.interfaces;

import com.bolivarSoftware.apolo.domain.EtapaARealizar;
import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.Proveedor;
import com.bolivarSoftware.apolo.domain.ServicioContratado;

import java.util.List;



public interface IServicioContratadoService extends ICommonService<ServicioContratado, Long> {
    ServicioContratado saveEtapasDelServicio(ServicioContratado servicioContratado);

     void delete (Long id);

    List<ServicioContratado> getBy(Proveedor proveedor);

    List<EtapaARealizar> getEtapasDelEvento(Evento evento);

    void save(List<ServicioContratado> servicios);
}
