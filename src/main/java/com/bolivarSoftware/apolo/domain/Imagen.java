package com.bolivarSoftware.apolo.domain;


import com.bolivarSoftware.apolo.enums.Carpeta;

/**
 * Created by Damian on 15/03/2018.
 */

public class Imagen {

    private String url;
    private boolean isMain;
    private String link;

    public Imagen(String url, boolean isMain) {
        this.url = url;
        this.isMain = isMain;
    }

    public Imagen(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
