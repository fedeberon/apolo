package com.bolivarSoftware.apolo.services.interfaces;

import com.bolivarSoftware.apolo.domain.Documento;
import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.Imagen;
import com.bolivarSoftware.apolo.domain.Salon;
import com.bolivarSoftware.apolo.enums.Carpeta;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by Federico_Veron on 26/10/2017.
 */
public interface IDocumentoService {
    void upload(Documento documento);

    List<Imagen> getDocumentos(Evento evento, Carpeta carpeta);

    List<Imagen> getDocumentos(Salon salon, Carpeta carpeta);

    Resource loadFileAsResource(String folder, String fileName);
}