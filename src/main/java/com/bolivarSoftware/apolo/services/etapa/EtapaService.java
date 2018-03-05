package com.bolivarSoftware.apolo.services.etapa;

import com.bolivarSoftware.apolo.domain.Etapa;
import com.bolivarSoftware.apolo.domain.EtapaARealizar;
import com.bolivarSoftware.apolo.persist.interfaces.IEtapaRepository;
import com.bolivarSoftware.apolo.services.interfaces.IEtapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fede Beron on 31/7/2017.
 */
@Service
public class EtapaService implements IEtapaService {

    @Autowired
    private IEtapaRepository dao;

    @Override
    public Etapa save(Etapa etapa){
        return dao.save(etapa);
    }

    @Override
    public List<EtapaARealizar> tareasProximas() {
        return dao.tareasProximas();
    }

}
