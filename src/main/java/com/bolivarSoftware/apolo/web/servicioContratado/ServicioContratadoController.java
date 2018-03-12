package com.bolivarSoftware.apolo.web.servicioContratado;

import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.ServicioContratado;
import com.bolivarSoftware.apolo.services.interfaces.IServicioContratadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("servicioContratado")
public class ServicioContratadoController {


    @Autowired
    private IServicioContratadoService servicioContratadoService;


    @RequestMapping("list")
    public String list() {
        return "servicioContratado/list";
    }


    @RequestMapping("show")
    public String get(@RequestParam Long id, Model model) {
        model.addAttribute("servicioContratado", servicioContratadoService.get(id));

        return "servicioContratado/show";
    }


    @RequestMapping("save")
    public String save(@ModelAttribute ServicioContratado servicioContratado, RedirectAttributes redirectAttributes) {
        servicioContratadoService.saveEtapasDelServicio(servicioContratado);
        redirectAttributes.addAttribute("id", servicioContratado.getId());

        return "redirect:show";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam Long id, @RequestParam Integer idEvento, RedirectAttributes redirectAttributes){
        servicioContratadoService.delete(id);
        redirectAttributes.addAttribute("id", idEvento);

        return "redirect:/evento/show";
    }

}
