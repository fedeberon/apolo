package com.bolivarSoftware.apolo.persist.interfaces;

import com.bolivarSoftware.apolo.domain.SugerenciaCancion;

import java.util.List;

public interface ISugerenciaCancionRepository {
    SugerenciaCancion save(SugerenciaCancion sugerenciaCancion);
    List<SugerenciaCancion> findAllByEventoId(Integer eventoId);
}
