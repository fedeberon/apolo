package com.bolivarSoftware.apolo.services.interfaces;

import com.bolivarSoftware.apolo.domain.Proveedor;

import java.util.List;

public interface IProveedorService extends ICommonService<Proveedor,Integer>{

    List<Proveedor> findAllByCreadoPor(String username);
}
