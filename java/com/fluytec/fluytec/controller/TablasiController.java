package com.fluytec.fluytec.controller;

import com.fluytec.fluytec.domain.Inventario;
import com.fluytec.fluytec.dao.InventarioDao;
import com.fluytec.fluytec.dao.ProductosDao;
import com.fluytec.fluytec.domain.Productos;
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
public class TablasiController {

    @Autowired
    private InventarioDao inventariosDao;
    
     @Autowired
    private ProductosDao productosDao;

    @GetMapping("/tables-bod")
    public String tables(Model model, Inventario inventario, Productos productos) {
        List<Inventario> lstInventario = new ArrayList<>();
        lstInventario = (List<Inventario>) inventariosDao.findAll();
        model.addAttribute("lstInventario", lstInventario);
        
        List<Productos> lstProductos = new ArrayList<>();
        lstProductos = (List<Productos>) productosDao.findAll();
        model.addAttribute("lstProductos", lstProductos);
        return "tablas-bod";
    }
    
    @GetMapping("/registroInventario_2")
    public String registroInventario_2(Inventario inventario) {
        return "registroInventario_2";
    }

    @PostMapping("/guardarDeInventario")
    public String guardarDeInventario(Inventario inventario) {
        inventariosDao.save(inventario);
        return "redirect:tables-bod";
    }

    @RequestMapping("/eliminarDeInventario")
    public String eliminarDeInventario(
            @RequestParam(name = "id_inventario", defaultValue = "0") Integer id_inventario) {
        inventariosDao.deleteById(id_inventario);
        return "redirect:tables-bod";
    }

    @RequestMapping("/modificarDeInventario")
    public String modificarDeInventario(
            @RequestParam(name = "id_inventario", defaultValue = "0") Integer id_inventario, Model model ) {
        Inventario inventario = inventariosDao.findById(id_inventario).orElse(null);
        model.addAttribute("inventario", inventario);
        return "registroInventario_2";
    }
    @GetMapping("/registroProductos2")
    public String registroProductos2(Productos productos) {
        return "registroProductos2";
    }

    @PostMapping("/guardarProductos2")
    public String guardarProductos2(Productos productos) {
        productosDao.save(productos);
        return "redirect:tables-bod";
    }

    @RequestMapping("/eliminarProductos2")
    public String eliminarProductos2(
            @RequestParam(name = "id_productos", defaultValue = "0") Integer id_productos) {
        productosDao.deleteById(id_productos);
        return "redirect:tables-bod";
    }

    @RequestMapping("/modificarProductos2")
    public String modificarProducto2(
            @RequestParam(name = "id_productos", defaultValue = "0") Integer id_productos, Model model) {
        Productos productos = productosDao.findById(id_productos).orElse(null);
        model.addAttribute("productos", productos);
        return "registroProductos2";
    }

}
