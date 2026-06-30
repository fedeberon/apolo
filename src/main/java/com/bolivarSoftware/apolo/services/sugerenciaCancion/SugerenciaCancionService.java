package com.bolivarSoftware.apolo.services.sugerenciaCancion;

import com.bolivarSoftware.apolo.domain.SugerenciaCancion;
import com.bolivarSoftware.apolo.persist.interfaces.ISugerenciaCancionRepository;
import com.bolivarSoftware.apolo.services.interfaces.ISugerenciaCancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SugerenciaCancionService implements ISugerenciaCancionService {

    @Autowired
    private ISugerenciaCancionRepository dao;

    @Override
    public SugerenciaCancion save(SugerenciaCancion sugerenciaCancion) {
        return dao.save(sugerenciaCancion);
    }

    @Override
    public List<SugerenciaCancion> findAllByEventoId(Integer eventoId) {
        return dao.findAllByEventoId(eventoId);
    }
}
