package com.bolivarSoftware.apolo.services.proveedor;


import com.bolivarSoftware.apolo.domain.Proveedor;
import com.bolivarSoftware.apolo.persist.interfaces.IProveedorRepository;
import com.bolivarSoftware.apolo.services.interfaces.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private IProveedorRepository dao;

    @Override
    public Proveedor get(Integer id) {
        return dao.get(id);
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return dao.save(proveedor);
    }

    @Override
    public List<Proveedor> findAll() {
        return dao.findAll();
    }
}
