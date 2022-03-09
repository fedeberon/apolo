package com.bolivarSoftware.apolo.web.documento;

import com.bolivarSoftware.apolo.domain.Documento;
import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.Imagen;
import com.bolivarSoftware.apolo.domain.Salon;
import com.bolivarSoftware.apolo.enums.Carpeta;
import com.bolivarSoftware.apolo.services.interfaces.IDocumentoService;
import com.bolivarSoftware.apolo.services.interfaces.IEventoService;
import com.bolivarSoftware.apolo.services.interfaces.ISalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("documento")
public class DocumentoController {

    private IDocumentoService documentoService;

    private IEventoService eventoService;

    private ISalonService salonService;

    @Autowired
    public DocumentoController(final IDocumentoService documentoService,
                               final IEventoService eventoService,
                               final ISalonService salonService) {
        this.documentoService = documentoService;
        this.eventoService = eventoService;
        this.salonService = salonService;
    }

    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public String uploadFile(@ModelAttribute Documento documento,
                             @RequestParam String urlRedirect) {
        documentoService.upload(documento);

        return "redirect:/" + urlRedirect;
    }

    @ModelAttribute("documento")
    private Documento getDocumento(){
        return new Documento();
    }

    @RequestMapping("salones/{folder}")
    public ResponseEntity<List<Imagen>> readFilesSalones(@PathVariable final Integer id) {
        Salon salon = salonService.get(id);
        final List<Imagen> images = documentoService.getDocumentos(salon, Carpeta.IMAGENES);
        images.forEach(image -> {
            String path = ServletUriComponentsBuilder.fromCurrentContextPath()
                            .path("/data/IMAGENES")
                            .path(id.toString())
                            .path(File.separator)
                            .path(image.getUrl())
                            .toUriString();
            image.setLink(path);
        });

        return ResponseEntity.ok(images);
    }

    @RequestMapping("eventos/{folder}")
    public ResponseEntity<List<Imagen>> readFilesEventos(@PathVariable final Integer id) {
        Evento evento = eventoService.get(id);
        final List<Imagen> images = documentoService.getDocumentos(evento, Carpeta.IMAGENES);
        images.forEach(image -> {
            String path = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/data/IMAGENES")
                    .path(id.toString())
                    .path(File.separator)
                    .path(image.getUrl())
                    .toUriString();
            image.setLink(path);
        });

        return ResponseEntity.ok(images);
    }

    @RequestMapping("data/{folder}/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable final String folder,
                                                 @PathVariable final String fileName,
                                                 final HttpServletRequest request) {
        final Resource resource = documentoService.loadFileAsResource(folder, fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (Exception ex) {
        }
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }

}



