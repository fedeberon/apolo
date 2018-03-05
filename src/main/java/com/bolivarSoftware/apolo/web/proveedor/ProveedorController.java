package com.bolivarSoftware.apolo.web.proveedor;

import com.bolivarSoftware.apolo.domain.Proveedor;
import com.bolivarSoftware.apolo.services.interfaces.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("proveedor")
public class ProveedorController {

    @Autowired
    private IProveedorService proveedorService;

    @RequestMapping("create")
    public String create(){
        return "proveedor/create";
    }

    @ModelAttribute("proveedor")
    public Proveedor getProveedor(){
        return new Proveedor();
    }

    @RequestMapping("save")
    public String save(@ModelAttribute Proveedor proveedor){
        proveedorService.save(proveedor);

        return "redirect:list";
    }

    @RequestMapping("list")
    public String list(Model model){
        model.addAttribute("proveedores", proveedorService.findAll());

        return "proveedor/list";
    }
}
