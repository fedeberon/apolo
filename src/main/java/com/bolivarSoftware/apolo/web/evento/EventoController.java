package com.bolivarSoftware.apolo.web.evento;

import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.Servicio;
import com.bolivarSoftware.apolo.domain.ServicioContratado;
import com.bolivarSoftware.apolo.enums.Carpeta;
import com.bolivarSoftware.apolo.services.interfaces.IDocumentoService;
import com.bolivarSoftware.apolo.services.interfaces.IEventoService;
import com.bolivarSoftware.apolo.services.interfaces.IEventoUsuarioService;
import com.bolivarSoftware.apolo.services.interfaces.IServicioContratadoService;
import com.bolivarSoftware.apolo.web.servicio.interfaces.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("evento")
public class EventoController {

    @Autowired
    private IServicioService servicioService;

    @Autowired
    private IEventoService eventoService;

    @Autowired
    private IDocumentoService documentoService;

    @Autowired
    private IServicioContratadoService servicioContratadoService;

    @Autowired
    private IEventoUsuarioService eventoUsuarioService;

    @RequestMapping("create")
    public String nuevoEvento() {
        return "evento/create";
    }

    @RequestMapping("save")
    public String save(@ModelAttribute Evento evento, RedirectAttributes redirectAttributes) {
        eventoService.save(evento);
        redirectAttributes.addAttribute("id", evento.getId());

        return "redirect:show";
    }

    @RequestMapping("show")
    public String show(@RequestParam Integer id, Model model) {
        Evento evento = eventoService.get(id);
        model.addAttribute("evento", evento);
        model.addAttribute("contratos" , documentoService.getDocumentos(evento, Carpeta.CONTRATOS));
        model.addAttribute("facturas" , documentoService.getDocumentos(evento, Carpeta.FACTURAS));
        model.addAttribute("documentos" , documentoService.getDocumentos(evento, Carpeta.DOCUMENTOS));
        model.addAttribute("serviciosContratados", eventoService.getServiciosContratados(evento));

        return "evento/show";
    }


    @RequestMapping("list")
    public String list(@RequestParam(defaultValue = "1" , required = false) Integer page,Model model) {
        model.addAttribute("eventos", eventoService.findAllPageable(page));
        model.addAttribute("page", page);

        return "evento/list";
    }

    @RequestMapping("asignarServicio")
    public String asignarServicio(@RequestParam Integer id, Model model) {
        Evento evento = eventoService.get(id);
        model.addAttribute("evento", evento);
        model.addAttribute("servicios", servicioService.findAll(evento));

        return "evento/asignarServicio";
    }

    @ModelAttribute
    public Evento evento() {
        return new Evento();
    }

    @ModelAttribute("servicios")
    public List<Servicio> getServicios() {
        return servicioService.findAll();
    }


    @RequestMapping("saveServiciosContratados")
    public String saveServiciosContratados(@ModelAttribute Evento evento, RedirectAttributes redirectAttributes) {
        servicioContratadoService.save(evento.getServicios());
        redirectAttributes.addAttribute("id", evento.getId());

        return "redirect:show";
    }


    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("delete")
    public String delete(@RequestParam Integer id){

        eventoService.delete(id);

        return "redirect:list";
    }

    @RequestMapping("timeline")
    public String timeLine(@RequestParam Integer id, Model model){
        Evento evento = eventoService.get(id);
        model.addAttribute("evento", evento);
        model.addAttribute("etapas", servicioContratadoService.getEtapasDelEvento(evento));


        return "timeline/show";
    }



}
