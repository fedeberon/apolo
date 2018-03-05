package com.bolivarSoftware.apolo.domain;

import com.bolivarSoftware.apolo.enums.Carpeta;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by Federico_Veron on 26/10/2017.
 */
@Component
public class Documento {

    @Value("${filePathFolder}")
    private String filePathFolder;

    private String carpeta;

    private Integer idEvento;

    private String nombre;

    private MultipartFile file;

    public Documento() {
    }

    public Documento(Carpeta carpeta, Integer idEvento, String nombre) {
        this.nombre = nombre;
        this.carpeta = carpeta.name();
        this.idEvento = idEvento;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getUrl() {
        return filePathFolder + File.separator + carpeta + File.separator + idEvento + File.separator + nombre;
    }
}
