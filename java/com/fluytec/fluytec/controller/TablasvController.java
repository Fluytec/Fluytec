package com.fluytec.fluytec.controller;

import com.fluytec.fluytec.dao.ProductosDao;
import com.fluytec.fluytec.dao.ventaDao;
import com.fluytec.fluytec.domain.Productos;
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
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TablasvController {

    @Autowired
    private ventaDao ventaDao;
    
    @Autowired
    private ProductosDao productosDao;

    @GetMapping("/tables-ventas")
    public String tables_ventas(Model model, Productos productos) {
        List<Venta> lstVenta = new ArrayList<>();
        lstVenta = (List<Venta>) ventaDao.findAll();
        model.addAttribute("lstVenta", lstVenta);
        
        List<Productos> lstProductos = new ArrayList<>();
        lstProductos = (List<Productos>) productosDao.findAll();
        model.addAttribute("lstProductos", lstProductos);
        return "tables-ventas";
    }

    @GetMapping("/registroVenta_2")
    public String registroVenta_2(Venta venta) {
        return "registroVenta_2";
    }

    @PostMapping("/guardarDeVenta")
    public String guardarDeVenta(Venta venta) {
        ventaDao.save(venta);
        return "redirect:tables-ventas";
    }

    @RequestMapping("/eliminarDeVenta")
    public String eliminarDeVenta(
            @RequestParam(name = "id_venta", defaultValue = "0") Integer id_venta) {
        ventaDao.deleteById(id_venta);
        return "redirect:tables-ventas";
    }

    @RequestMapping("/modificarDeVenta")
    public String modificarDeVenta(
            @RequestParam(name = "id_venta", defaultValue = "0") Integer id_venta, Model model) {
        Venta venta = ventaDao.findById(id_venta).orElse(null);
        model.addAttribute("venta", venta);
        return "registroVenta_2";
    }
    public String productos(Model model, Productos productos) {
        String salida = "Enviando informacion desde el controlador hacia la vista";
        Productos pro = new Productos();
        List<Productos> lstProductos = new ArrayList<>();
        lstProductos = (List<Productos>) productosDao.findAll();

        model.addAttribute("lstProductos", lstProductos);
        model.addAttribute("productos", pro);
        model.addAttribute("salida", salida);
        return "tables-ventas";
    }

    @GetMapping("/registroProductos")
    public String registroProductos(Productos productos) {
        return "registroProductos";
    }

    @PostMapping("/guardarProductos")
    public String guardarProductos(Productos productos) {
        productosDao.save(productos);
        return "redirect:tables-ventas";
    }

    @RequestMapping("/eliminarProductos")
    public String eliminarProductos(
            @RequestParam(name = "id_productos", defaultValue = "0") Integer id_productos) {
        productosDao.deleteById(id_productos);
        return "redirect:tables-ventas";
    }

    @RequestMapping("/modificarProductos")
    public String modificarProductos(
            @RequestParam(name = "id_productos", defaultValue = "0") Integer id_productos, Model model) {
        Productos productos = productosDao.findById(id_productos).orElse(null);
        model.addAttribute("productos", productos);
        return "registroProductos";
    }

    
}
