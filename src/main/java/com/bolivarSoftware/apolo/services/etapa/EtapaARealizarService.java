package com.bolivarSoftware.apolo.services.etapa;

import com.bolivarSoftware.apolo.persist.interfaces.IEtapaARealizarRepository;
import com.bolivarSoftware.apolo.persist.interfaces.IServicioContratadoRepository;
import com.bolivarSoftware.apolo.services.interfaces.IEtapaARealizarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 09/03/2018.
 */
@Service
public class EtapaARealizarService implements IEtapaARealizarService{

    @Autowired
    private IEtapaARealizarRepository dao;

    @Override
    public void delete(Long id) {
        dao.remove(id);
    }
}
