package com.fluytec.fluytec.controller;

import com.fluytec.fluytec.dao.InventarioDao;
import com.fluytec.fluytec.domain.Inventario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InventarioController {
    
    @Autowired
    private InventarioDao inventariosDao;
    
    @GetMapping("/index-bod")
    public String inventario(Model model, Inventario inventario) {
        List<Inventario> lstInventario = new ArrayList<>();
        lstInventario = (List<Inventario>) inventariosDao.findAll();
        model.addAttribute("lstInventario", lstInventario);
        return "index-bod";
    }
    
    @GetMapping("/registroInventario_1")
    public String registroInventario_1(Inventario inventario) {
        return "registroInventario_1";
    }

    @PostMapping("/guardarInventarioModulo")
    public String guardarInventarioModulo(Inventario inventario) {
        inventariosDao.save(inventario);
        return "redirect:index-bod";
    }

    @RequestMapping("/eliminarInventarioModulo")
    public String eliminarInventarioModulo(
            @RequestParam(name = "id_inventario", defaultValue = "0") Integer id_inventario) {
        inventariosDao.deleteById(id_inventario);
        return "redirect:index-bod";
    }

    @RequestMapping("/modificarInventarioModulo")
    public String modificarInventarioModulo(
            @RequestParam(name = "id_inventario", defaultValue = "0") Integer id_inventario, Model model) {
        Inventario inventario = inventariosDao.findById(id_inventario).orElse(null);
        model.addAttribute("inventario", inventario);
        return "registroInventario_1";
    }
    
    @GetMapping("/form-bod")
    public String form() {
        return "formularios-bod";
    }
    
    @GetMapping("/calendar-bod")
    public String calendar() {
        return "calendario-bod";
    }
    
    @GetMapping("/editors-bod")
    public String editors() {
        return "observaciones-bod";
    }
}
