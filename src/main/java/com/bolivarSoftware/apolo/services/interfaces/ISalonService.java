package com.bolivarSoftware.apolo.services.interfaces;

import com.bolivarSoftware.apolo.domain.Salon;

import java.util.List;

/**
 * Created by Damian on 15/03/2018.
 */
public interface ISalonService {

    Salon save(Salon salon);

    List<Salon> findAll();

    List<Salon> findAllPageable(Integer page);

    Salon get(Integer id);
}
