package com.bolivarSoftware.apolo.web.servicio;

import com.bolivarSoftware.apolo.domain.Etapa;
import com.bolivarSoftware.apolo.domain.Proveedor;
import com.bolivarSoftware.apolo.domain.Servicio;
import com.bolivarSoftware.apolo.services.interfaces.IProveedorService;
import com.bolivarSoftware.apolo.web.servicio.interfaces.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("servicio")
public class ServicioController {

    @Autowired
    private IServicioService servicioService;

    @Autowired
    private IProveedorService proveedorService;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("servicios", servicioService.findAll());

        return "servicio/list";
    }

    @RequestMapping("save")
    public String save(@ModelAttribute Servicio servicio) {
        servicioService.save(servicio);

        return "redirect:list";
    }

    @ModelAttribute("proveedores")
    private List<Proveedor> getProveedores() {
        return proveedorService.findAll();
    }

    @RequestMapping("create")
    private String create() {
        return "servicio/create";
    }

    @ModelAttribute("servicio")
    private Servicio getServicio() {
        return new Servicio();
    }

    @RequestMapping("show")
    private String show(@RequestParam Integer id, Model model) {
        model.addAttribute("servicio", servicioService.get(id));

        return "servicio/show";
    }

    @ModelAttribute("etapa")
    public Etapa getEtapa() {
        return new Etapa();
    }
}
