package com.bolivarSoftware.apolo.services.salon;

import com.bolivarSoftware.apolo.domain.Salon;
import com.bolivarSoftware.apolo.persist.interfaces.ISalonRepository;
import com.bolivarSoftware.apolo.services.interfaces.ISalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian on 15/03/2018.
 */
@Service
public class SalonService implements ISalonService{

    @Autowired
    private ISalonRepository dao;

    @Override
    public Salon save(Salon salon) {
        return dao.save(salon);
    }

    @Override
    public List<Salon> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Salon> findAllPageable(Integer page) {
        return dao.findAllPageable(page);
    }

    @Override
    public Salon get(Integer id) {
        return dao.get(id);
    }

}
