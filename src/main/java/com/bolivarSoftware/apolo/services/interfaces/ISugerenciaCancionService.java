package com.bolivarSoftware.apolo.services.interfaces;

import com.bolivarSoftware.apolo.domain.SugerenciaCancion;

import java.util.List;

public interface ISugerenciaCancionService {
    SugerenciaCancion save(SugerenciaCancion sugerenciaCancion);
    List<SugerenciaCancion> findAllByEventoId(Integer eventoId);
}
