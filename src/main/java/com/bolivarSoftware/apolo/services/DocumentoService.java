package com.bolivarSoftware.apolo.services;

import com.bolivarSoftware.apolo.domain.Documento;
import com.bolivarSoftware.apolo.domain.Evento;
import com.bolivarSoftware.apolo.domain.Imagen;
import com.bolivarSoftware.apolo.domain.Salon;
import com.bolivarSoftware.apolo.enums.Carpeta;
import com.bolivarSoftware.apolo.services.interfaces.IDocumentoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Federico_Veron on 26/10/2017.
 */

@Service
public class DocumentoService implements IDocumentoService {

    @Value("${filePathFolder}")
    private String filePathFolder;

    @Override
    public void upload(Documento documento) {
        if (documento.getFile().isEmpty()) return;
        try {
            File theDir  = new File(filePathFolder + File.separator + documento.getCarpeta() + File.separator  + documento.getSubCarpeta());
            File theDirWithFile = new File(theDir.getAbsolutePath() + File.separator + documento.getFile().getOriginalFilename());
            theDirWithFile = this.getVersionFile(theDir, theDirWithFile);

            Path path = Paths.get(theDir.getAbsolutePath());
            Files.createDirectories(path);

            documento.getFile().transferTo(theDirWithFile);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
    }


    public File getVersionFile(File theDir, File theDirWithFile) {
        Integer version = 1;

        while(theDirWithFile.exists()){
            File fileRename = new File(theDir.getAbsolutePath() + File.separator + getFileName(theDirWithFile) + "_V" + version + "." + getFileExtension(theDirWithFile));
            theDirWithFile.renameTo(fileRename);
            version++;
        }

        return theDirWithFile;
    }

    public String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }

    public String getFileName(File file) {
        String name = file.getName();
        try {
            return name.substring(0, name.lastIndexOf("."));
        } catch (Exception e) {
            return "";
        }
    }


    @SuppressWarnings("Duplicates")
    @Override
    public List<Imagen> getDocumentos(Evento evento, Carpeta carpeta){
        final List<Imagen> documentos = new ArrayList<>();
        try {
            Files.walkFileTree(Paths.get(filePathFolder + File.separator + carpeta + File.separator + evento.getId()), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    try {
                        documentos.add(new Imagen(file.getFileName().toString()));
                    }
                    finally {
                        return FileVisitResult.CONTINUE;
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return documentos;
    }


    @SuppressWarnings("Duplicates")
    @Override
    public List<Imagen> getDocumentos(Salon salon, Carpeta carpeta){
        final List<Imagen> imagens = new ArrayList<>();
        try {
            Files.walkFileTree(Paths.get(filePathFolder + File.separator + carpeta + File.separator + salon.getId()), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    try {
                        imagens.add(new Imagen(file.getFileName().toString()));
                    }
                    finally {
                        return FileVisitResult.CONTINUE;
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagens;
    }


    public Resource loadFileAsResource(String folder, String fileName) {
        try {
            Path filePath = Paths.get(this.filePathFolder + folder.concat("/").concat(fileName));
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                return null;
            }
        } catch (MalformedURLException ex) {
            return null;
        }
    }
 }
