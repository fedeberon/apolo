package com.bolivarSoftware.apolo.services.servicioContratado;

import com.bolivarSoftware.apolo.domain.EtapaARealizar;
import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.Proveedor;
import com.bolivarSoftware.apolo.domain.ServicioContratado;
import com.bolivarSoftware.apolo.persist.interfaces.IServicioContratadoRepository;
import com.bolivarSoftware.apolo.services.interfaces.IServicioContratadoService;
import org.apache.commons.collections.ArrayStack;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;


@Service
public class ServicioContratadoService  implements IServicioContratadoService{

    @Autowired
    private IServicioContratadoRepository dao;

    @Override
    public ServicioContratado get(Long id) {
        return dao.get(id);
    }

    @Override
    public ServicioContratado save(ServicioContratado servicioContratado) {
        return dao.save(servicioContratado);
    }

    @Override
    public List<ServicioContratado> findAll() {
        return dao.findAll();
    }

    @Override
    public ServicioContratado saveEtapasDelServicio(ServicioContratado servicioContratado) {
        return dao.saveEtapasDelServicio(servicioContratado);
    }

    @Override
    public void delete(Long id) {
        dao.remove(id);
    }

    @Override
    public List<ServicioContratado> getBy(Proveedor proveedor){
        return dao.getBy(proveedor);
    }


    @Override
    public List<EtapaARealizar> getEtapasDelEvento(Evento evento){
        List<EtapaARealizar> etapasDelEvento = new ArrayList<>();
        evento.getServicios().forEach(servicioContratado -> {
            final ServicioContratado servicio = this.get(servicioContratado.getId());
            etapasDelEvento.addAll(servicio.getEtapas());
        });
        this.calcularDiasRestantesParaCumplirTarea(evento, etapasDelEvento);
        Collections.sort(etapasDelEvento);

        return etapasDelEvento;
    }

    public void calcularDiasRestantesParaCumplirTarea(Evento evento, List<EtapaARealizar>  etapasDelEvento){
        if(evento.getFechaDeEvento() == null) return;

        Date fecha = evento.getFechaDeEvento();
        LocalDateTime fechaACalcular = LocalDateTime.ofInstant(fecha.toInstant(), ZoneId.systemDefault());

        for (int i = 0 ; i < etapasDelEvento.size(); i++){
            if(etapasDelEvento.get(i).getCantidadDiasLimiteDeResolucion() == null) continue;
            Integer dias = etapasDelEvento.get(i).getCantidadDiasLimiteDeResolucion();
            LocalDateTime  fechaDeResolucion = fechaACalcular.minus(dias, ChronoUnit.DAYS);
            etapasDelEvento.get(i).setFecha(fechaDeResolucion);
        }
    }
}
