package com.bolivarSoftware.apolo.web.salon;

import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.Salon;
import com.bolivarSoftware.apolo.domain.Usuario;
import com.bolivarSoftware.apolo.domain.UsuarioDetails;
import com.bolivarSoftware.apolo.enums.Carpeta;
import com.bolivarSoftware.apolo.services.interfaces.IDocumentoService;
import com.bolivarSoftware.apolo.services.interfaces.IEventoService;
import com.bolivarSoftware.apolo.services.interfaces.ISalonService;
import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Damian on 15/03/2018.
 */

@Controller
@RequestMapping("salon")
public class SalonController {

    @Autowired
    private ISalonService salonService;

    @Autowired
    private IDocumentoService documentoService;

    @Autowired
    private IUsuarioService usuarioService;

    @RequestMapping("create")
    public String nuevoSalon() {
        return "salon/create";
    }

    @RequestMapping("show")
    public String show(@RequestParam Integer id, Model model) {
        Salon salon = salonService.get(id);
        model.addAttribute("salon", salon);
        model.addAttribute("imagenes" , documentoService.getDocumentos(salon, Carpeta.IMAGENES));

        return "salon/show";
    }

    @RequestMapping("list")
    public String list(@RequestParam(defaultValue = "1" , required = false) Integer page,Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UsuarioDetails) {
            UsuarioDetails userDetails = (UsuarioDetails) auth.getPrincipal();
            model.addAttribute("salones", salonService.findAllByCreadoPor(userDetails.getUsername()));
        } else {
            model.addAttribute("salones", salonService.findAllPageable(page));
        }
        model.addAttribute("page", page);

        return "salon/list";
    }


    @RequestMapping("save")
    public String save(@ModelAttribute Salon salon, RedirectAttributes redirectAttributes) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UsuarioDetails) {
            UsuarioDetails userDetails = (UsuarioDetails) auth.getPrincipal();
            Usuario admin = usuarioService.get(userDetails.getUsername());
            salon.setCreadoPor(admin);
        }
        salonService.save(salon);
        redirectAttributes.addAttribute("id", salon.getId());

        return "redirect:show";
    }

    @RequestMapping("edit")
    public String edit(@RequestParam Integer id, Model model) {
        Salon salon = salonService.get(id);
        model.addAttribute("salon", salon);

        return "salon/edit";
    }

    @ModelAttribute("salon")
    public Salon getSalon(){
        return new Salon();
    }
}
