package com.bolivarSoftware.apolo.web.documento;

import com.bolivarSoftware.apolo.domain.Documento;
import com.bolivarSoftware.apolo.services.interfaces.IDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("documento")
public class DocumentoController {

    @Autowired
    private IDocumentoService documentoService;

    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public String uploadFile(@ModelAttribute Documento documento,
                             RedirectAttributes redirectAttributes) {
        documentoService.upload(documento);
        redirectAttributes.addAttribute("id", documento.getIdEvento());

        return "redirect:/articulos/show";
    }

    @ModelAttribute("documento")
    private Documento getDocumento(){
        return new Documento();
    }




}
