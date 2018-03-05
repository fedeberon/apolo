package com.bolivarSoftware.apolo.persist.interfaces;


import com.bolivarSoftware.apolo.domain.Proveedor;

import java.util.List;

public interface IProveedorRepository {

    Proveedor get(Integer id);

    Proveedor save(Proveedor proveedor);

    List<Proveedor> findAll();
}
