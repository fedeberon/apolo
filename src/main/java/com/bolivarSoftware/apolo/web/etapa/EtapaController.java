package com.bolivarSoftware.apolo.web.etapa;

import com.bolivarSoftware.apolo.domain.Etapa;
import com.bolivarSoftware.apolo.services.interfaces.IEtapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Fede Beron on 31/7/2017.
 */
@Controller
@RequestMapping("etapas")
public class EtapaController {

    @Autowired
    private IEtapaService etapaService;

    @RequestMapping("save")
    public String save(@ModelAttribute Etapa etapa, RedirectAttributes redirectAttributes){
        etapaService.save(etapa);
        redirectAttributes.addAttribute("id" , etapa.getServicio().getId());

        return "redirect:/servicio/show";
    }

    @ModelAttribute("etapa")
    public Etapa getEtapa(){
        return new Etapa();
    }

}
