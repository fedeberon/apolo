package com.bolivarSoftware.apolo.services.interfaces;

import com.bolivarSoftware.apolo.domain.Etapa;
import com.bolivarSoftware.apolo.domain.EtapaARealizar;

import java.util.List;

/**
 * Created by Fede Beron on 31/7/2017.
 */
public interface IEtapaService {
    Etapa save(Etapa etapa);

    List<EtapaARealizar> tareasProximas();
}
