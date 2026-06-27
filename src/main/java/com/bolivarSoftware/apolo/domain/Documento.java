package com.bolivarSoftware.apolo.domain;

import com.bolivarSoftware.apolo.enums.Carpeta;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@Component
public class Documento {

    private String filePathFolder = "/documento";

    private String carpeta;

    private String subCarpeta;

    private String nombre;

    private MultipartFile file;

    public Documento() {
    }

    public Documento(Carpeta carpeta, String subCarpeta, String nombre) {
        this.nombre = nombre;
        this.carpeta = carpeta.name();
        this.subCarpeta = subCarpeta;
    }

    public String getFilePathFolder() {
        return filePathFolder;
    }

    public void setFilePathFolder(String filePathFolder) {
        this.filePathFolder = filePathFolder;
    }

    public String getSubCarpeta() {
        return subCarpeta;
    }

    public void setSubCarpeta(String subCarpeta) {
        this.subCarpeta = subCarpeta;
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
        return filePathFolder + File.separator + carpeta + File.separator + subCarpeta + File.separator + nombre;
    }
}
