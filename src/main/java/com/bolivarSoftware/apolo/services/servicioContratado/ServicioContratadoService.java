package com.bolivarSoftware.apolo.services.servicioContratado;

import com.bolivarSoftware.apolo.domain.ServicioContratado;
import com.bolivarSoftware.apolo.persist.interfaces.IServicioContratadoRepository;
import com.bolivarSoftware.apolo.services.interfaces.IServicioContratadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServicioContratadoService  implements IServicioContratadoService{

    @Autowired
    private IServicioContratadoRepository dao;

    @Override
    public ServicioContratado get(Long aLong) {
        return dao.get(aLong);
    }

    @Override
    public ServicioContratado save(ServicioContratado servicioContratado) {
        return dao.save(servicioContratado);
    }

    @Override
    public List<ServicioContratado> findAll() {
        return dao.findAll();
    }

    @Override
    public ServicioContratado saveEtapasDelServicio(ServicioContratado servicioContratado) {
        return dao.saveEtapasDelServicio(servicioContratado);
    }

    @Override
    public void delete(Long id) {
        dao.remove(id);
    }
}
