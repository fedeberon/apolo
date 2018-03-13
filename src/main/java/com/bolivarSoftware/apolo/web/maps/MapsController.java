package com.bolivarSoftware.apolo.web.maps;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Damian on 12/03/2018.
 */
@Controller
@RequestMapping("maps")
public class MapsController {

    @RequestMapping("/")
    public String maps(){
        return "maps/mapa";
    }
}
