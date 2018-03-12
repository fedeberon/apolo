package com.bolivarSoftware.apolo.web.etapa;

import com.bolivarSoftware.apolo.services.interfaces.IEtapaARealizarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Damian on 09/03/2018.
 */

@Controller
@RequestMapping("tareas")
public class EtapaARealizarController {

    @Autowired
    private IEtapaARealizarService etapaARealizarService;

    @RequestMapping("delete")
    public String delete(@RequestParam Long id, @RequestParam Integer idServicio, RedirectAttributes redirectAttributes){
        etapaARealizarService.delete(id);
        redirectAttributes.addAttribute("id", idServicio);

        return "redirect:/servicioContratado/show";
    }
}
