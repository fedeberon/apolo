package com.bolivarSoftware.apolo.web.proveedor;

import com.bolivarSoftware.apolo.domain.Proveedor;
import com.bolivarSoftware.apolo.domain.Usuario;
import com.bolivarSoftware.apolo.domain.UsuarioDetails;
import com.bolivarSoftware.apolo.services.interfaces.IProveedorService;
import com.bolivarSoftware.apolo.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("proveedor")
public class ProveedorController {

    @Autowired
    private IProveedorService proveedorService;

    @Autowired
    private IUsuarioService usuarioService;

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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UsuarioDetails) {
            UsuarioDetails userDetails = (UsuarioDetails) auth.getPrincipal();
            Usuario admin = usuarioService.get(userDetails.getUsername());
            proveedor.setCreadoPor(admin);
        }
        proveedorService.save(proveedor);

        return "redirect:list";
    }

    @RequestMapping("list")
    public String list(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UsuarioDetails) {
            UsuarioDetails userDetails = (UsuarioDetails) auth.getPrincipal();
            model.addAttribute("proveedores", proveedorService.findAllByCreadoPor(userDetails.getUsername()));
        } else {
            model.addAttribute("proveedores", proveedorService.findAll());
        }

        return "proveedor/list";
    }

    @RequestMapping("show")
    public String show(@RequestParam Integer id, Model model) {
        Proveedor proveedor = proveedorService.get(id);
        model.addAttribute("proveedor", proveedor);

        return "proveedor/show";
    }
}
