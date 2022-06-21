package com.fluytec.fluytec.controller;

import com.fluytec.fluytec.dao.ventaDao;
import com.fluytec.fluytec.domain.Venta;
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
public class VentasController {
    
    @Autowired
    private ventaDao ventaDao;
    
    @GetMapping("/index-ventas")
    public String venta(Model model, Venta venta) {        
        List<Venta> lstVenta = new ArrayList<>();
        lstVenta = (List<Venta>) ventaDao.findAll();
        model.addAttribute("lstVenta", lstVenta);
        return "index-ventas";
    }
    
     /*   
       @PostMapping("/guardarVentaModulo")
    public String guardarVentaModulo(Model model,Venta venta) {
        ventaDao.save(venta);
        List<Venta> lstVenta = new ArrayList<>();
        lstVenta = (List<Venta>) ventaDao.findAll();
        model.addAttribute("lstVenta", lstVenta);
        return "index-ventas";

        //return "redirect:tables";
    }*/
    
    @GetMapping("/registroVenta_1")
    public String registroVenta_1(Venta venta) {
        return "registroVenta_1";
    }

    @PostMapping("/guardarVentaModulo")
    public String guardarVentaModulo(Venta venta) {
        ventaDao.save(venta);
        return "redirect:index-ventas";
    }

    @RequestMapping("/eliminarVentaModulo")
    public String eliminarVentaModulo(
            @RequestParam(name = "id_venta", defaultValue = "0") Integer id_venta) {
        ventaDao.deleteById(id_venta);
        return "redirect:index-ventas";
    }

    @RequestMapping("/modificarVentaModulo")
    public String modificarVentaModulo(
            @RequestParam(name = "id_venta", defaultValue = "0") Integer id_venta, Model model) {
        Venta venta = ventaDao.findById(id_venta).orElse(null);
        model.addAttribute("venta", venta);
        return "registroVenta_1";
    }
   
    @GetMapping("/form-ventas")
    public String form() {
        return "form-ventas";
    }
    
    @GetMapping("/calendar-ventas")
    public String calendar() {
        return "calendar-ventas";
    }
    
    @GetMapping("/editors-ventas")
    public String editors() {
        return "editors-ventas";
    }
}
