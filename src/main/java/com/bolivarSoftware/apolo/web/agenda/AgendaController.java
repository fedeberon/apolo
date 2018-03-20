package com.bolivarSoftware.apolo.web.agenda;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Damian on 19/03/2018.
 */

@Controller
@RequestMapping("agenda")
public class AgendaController {

    @RequestMapping("show")
    public String show(){

        return "agenda/show";
    }
}
