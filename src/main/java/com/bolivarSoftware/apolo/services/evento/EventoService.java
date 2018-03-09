package com.bolivarSoftware.apolo.services.evento;

import com.bolivarSoftware.apolo.domain.EtapaARealizar;
import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.Servicio;
import com.bolivarSoftware.apolo.domain.ServicioContratado;
import com.bolivarSoftware.apolo.persist.interfaces.IEventoRepository;
import com.bolivarSoftware.apolo.services.interfaces.IEventoService;
import com.bolivarSoftware.apolo.web.servicio.interfaces.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fede Beron on 8/8/2017.
 */
@Service
public class EventoService implements IEventoService{

    @Autowired
    private IEventoRepository dao;

    @Autowired
    private IServicioService servicioService;


    @Override
    public Evento get(Integer integer) {
        return dao.get(integer);
    }

    @Override
    public Evento save(Evento evento) {
        evento.getServicios().forEach(servicioContratado -> servicioContratado.setEvento(evento));

        evento.getServicios().forEach(servicioContratado -> {
            List<EtapaARealizar> etapas = new ArrayList<>();

            Servicio servicio = servicioService.get(servicioContratado.getServicio().getId());
            servicio.getEtapas().forEach(etapa -> {
                etapas.add(new EtapaARealizar(etapa, servicioContratado));
            });

            servicioContratado.setEtapas(etapas);
        });


        return dao.save(evento);
    }

    @Override
    public List<Evento> findAll() {
        return dao.findAll();
    }

    @Override
    public List<ServicioContratado> getServiciosContratados(Evento evento) {
        return dao.getServiciosContratados(evento);
    }

    @Override
    public List<Evento> findAllPageable(Integer page) {
        return dao.findAllPageable(page);
    }

    @Override
    public void delete(Integer id) {
        dao.remove(id);
    }
}
