package com.bolivarSoftware.apolo.services.evento;

import com.bolivarSoftware.apolo.domain.*;
import com.bolivarSoftware.apolo.persist.interfaces.IEventoRepository;
import com.bolivarSoftware.apolo.services.interfaces.IEventoService;
import com.bolivarSoftware.apolo.web.servicio.interfaces.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
        if(evento.getServicios() != null){
            evento.getServicios().removeIf(servicioContratado -> servicioContratado.getServicio() == null);
            evento.getServicios().forEach(servicioContratado -> servicioContratado.setEvento(evento));
            evento.getServicios().forEach(servicioContratado -> {
                List<EtapaARealizar> etapas = new ArrayList<>();
                Servicio servicio = servicioService.get(servicioContratado.getServicio().getId());
                servicio.getEtapas().forEach(etapa -> {
                    etapas.add(new EtapaARealizar(etapa, servicioContratado));
                });

                servicioContratado.setEtapas(etapas);
            });
        }

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
