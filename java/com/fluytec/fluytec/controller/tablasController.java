package com.fluytec.fluytec.controller;

//import org.apache.poi:poi:3.15;
//import org.apache.poi:poi-ooxml:3.15;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.fluytec.fluytec.dao.UsuarioDao;
import com.fluytec.fluytec.dao.ventaDao;
import com.fluytec.fluytec.dao.InventarioDao;
import com.fluytec.fluytec.dao.OrdenDeCompraDao;
import com.fluytec.fluytec.dao.ProductosDao;
import com.fluytec.fluytec.dao.proveedoresDao;
import com.fluytec.fluytec.domain.Usuario;
import com.fluytec.fluytec.domain.Inventario;
import com.fluytec.fluytec.domain.OrdenDeCompra;
import com.fluytec.fluytec.domain.Venta;
import com.fluytec.fluytec.domain.Productos;
import com.fluytec.fluytec.domain.Proveedores;
import com.fluytec.fluytec.domain.UploadFile;

import com.fluytec.gestion.usuarios.servicio.usuarioService;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class tablasController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private InventarioDao inventariosDao;

    @Autowired
    private ventaDao ventaDao;

    @Autowired
    private ProductosDao productosDao;

    @Autowired
    private proveedoresDao proveedoresDao;

    @Autowired
    private OrdenDeCompraDao ordenDeCompraDao;

    @GetMapping("/tables")
    public String tables(Model model, Venta venta) {
        List<Usuario> lstUsuarios;
        lstUsuarios = (List<Usuario>) usuarioDao.findAll();//select * from cliente
        model.addAttribute("lstUsuarios", lstUsuarios);
        List<Venta> lstVenta = new ArrayList<>();
        lstVenta = (List<Venta>) ventaDao.findAll();
        model.addAttribute("lstVenta", lstVenta);
        List<Inventario> lstInventario = new ArrayList<>();
        lstInventario = (List<Inventario>) inventariosDao.findAll();
        model.addAttribute("lstInventario", lstInventario);
        /*List<Productos> lstProductos = new ArrayList<>();
        lstProductos = (List<Productos>) productosDao.findAll();
        model.addAttribute("lstProductos", lstProductos);
        List<Proveedores> lstProveedores = new ArrayList<>();
        lstProveedores = (List<Proveedores>) proveedoresDao.findAll();
        model.addAttribute("lstProductos", lstProveedores);
        List<OrdenDeCompra> lstOrdenDeCompra = new ArrayList<>();
        lstOrdenDeCompra = (List<OrdenDeCompra>) ordenDeCompraDao.findAll();
        model.addAttribute("lstOrdenDeCompra", lstOrdenDeCompra);*/

        return "tables";
    }

    @GetMapping("/registroDeUsuario")
    public String registroDeUsuario(Usuario usuario) {
        return "registroUsuario_1";
    }

    @PostMapping("/guardarDeUsuario")
    public String guardarDeUsuario(Usuario usuario) {
        usuarioDao.save(usuario);
        return "redirect:tables";
    }

    @RequestMapping("/eliminarDeUsuario")
    public String eliminarDeUsuario(
            @RequestParam(name = "id_usuarios", defaultValue = "0") Integer id_usuarios) {
        usuarioDao.deleteById(id_usuarios);
        return "redirect:tables";
    }

    @RequestMapping("/modificarDeUsuario")
    public String modificarDeUsuario(
            @RequestParam(name = "id_usuarios", defaultValue = "0") Integer id_usuarios, Model model) {
        Usuario usuario = usuarioDao.findById(id_usuarios).orElse(null);
        model.addAttribute("usuario", usuario);
        return "registroUsuario_1";
    }

    @RequestMapping("/uploadFile")
    public String saveFileExcel(MultipartFile file, Model model) throws IOException, CsvValidationException {
        UploadFile upl = new UploadFile();
        List<Usuario> lstUsuarios = upl.guardarFile(file);

        this.usuarioDao.saveAll(lstUsuarios);

        return "redirect:index";
    }

    /* @GetMapping("/exportarPDF")
    public void exportarListadoUsuariosEnPDF(HttpServletResponse response) throws IOException{
        response.setContentType("application/pdf");
        
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd_HH:mm:ss");
        String fechaActual =dateFormatter.format(new Date());
        
        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Usuario_"+fechaActual+".pdf";
        
        response.setHeader(cabecera,valor);
        List<Usuario> usuario = usuarioService.findAll();
        
        UsuariosExporterPDF exporter = new UsuariosExporterPDF();
        exporter.exportar(response);
    }*/
    public String venta(Model model) {
        String salida = "Enviando informacion desde el controlador hacia la vista";
        Venta aux = new Venta();
        List<Venta> lstVenta = new ArrayList<>();
        lstVenta = (List<Venta>) ventaDao.findAll();

        model.addAttribute("lstVenta", lstVenta);
        model.addAttribute("venta", aux);
        model.addAttribute("salida", salida);
        return "tables";
    }

    @GetMapping("/registroVenta")
    public String registroVenta(Venta venta) {
        return "registroVenta";
    }

    @PostMapping("/guardarVenta")
    public String guardarVenta(Venta venta) {
        ventaDao.save(venta);
        return "redirect:tables";
    }

    @RequestMapping("/eliminarVenta")
    public String eliminarVenta(
            @RequestParam(name = "id_venta", defaultValue = "0") Integer id_venta) {
        ventaDao.deleteById(id_venta);
        return "redirect:tables";
    }

    @RequestMapping("/modificarVenta")
    public String modificarVenta(
            @RequestParam(name = "id_venta", defaultValue = "0") Integer id_venta, Model model) {
        Venta venta = ventaDao.findById(id_venta).orElse(null);
        model.addAttribute("venta", venta);
        return "registroVenta";
    }

    public String inventario(Model model) {
        String salida = "Enviando informacion desde el controlador hacia la vista";
        Inventario inv = new Inventario();
        List<Inventario> lstInventario = new ArrayList<>();
        lstInventario = (List<Inventario>) inventariosDao.findAll();

        model.addAttribute("lstInventario", lstInventario);
        model.addAttribute("inventario", inv);
        model.addAttribute("salida", salida);
        return "tables";
    }

    @GetMapping("/registroInventario")
    public String registroInventario(Inventario inventario) {
        return "registroInventario";
    }

    @PostMapping("/guardarInventario")
    public String guardarInventario(Inventario inventario) {
        inventariosDao.save(inventario);
        return "redirect:form";
    }

    @RequestMapping("/eliminarInventario")
    public String eliminarInventario(
            @RequestParam(name = "id_inventario", defaultValue = "0") Integer id_inventario) {
        inventariosDao.deleteById(id_inventario);
        return "redirect:form";
    }

    @RequestMapping("/modificarInventario")
    public String modificarInventario(
            @RequestParam(name = "id_inventario", defaultValue = "0") Integer id_inventario, Model model) {
        Inventario inventario = inventariosDao.findById(id_inventario).orElse(null);
        model.addAttribute("inventario", inventario);
        return "registroInventario";
    }

    
  /*  public String proveedores(Model model) {
        String salida = "Enviando informacion desde el controlador hacia la vista";
        Proveedores prov = new Proveedores();
        List<Proveedores> lstProveedores = new ArrayList<>();
        lstProveedores = (List<Proveedores>) proveedoresDao.findAll();

        model.addAttribute("lstProductos", lstProveedores);
        model.addAttribute("proveedores", prov);
        model.addAttribute("salida", salida);
        return "tables";
    }
    
    @GetMapping("/registroProveedores")
    public String registroProveedores(Proveedores proveedores) {
        return "registroProveedores";
    }

    @PostMapping("/guardarProveedores")
    public String guardarProveedores(Proveedores proveedores) {
        proveedoresDao.save(proveedores);
        return "redirect:tables";
    }

    @RequestMapping("/eliminarProveedores")
    public String eliminarProveedores(
            @RequestParam(name = "id_proveedores", defaultValue = "0") Integer id_proveedores) {
        proveedoresDao.deleteById(id_proveedores);
        return "redirect:tables";
    }

    @RequestMapping("/modificarProveedores")
    public String modificarProveedores(
            @RequestParam(name = "id_proveedores", defaultValue = "0") Integer id_proveedores, Model model) {
        Proveedores proveedores = proveedoresDao.findById(id_proveedores).orElse(null);
        model.addAttribute("proveedores", proveedores);
        return "registroProveedores";
    }
    
    public String OrdenDeCompra(Model model) {
        String salida = "Enviando informacion desde el controlador hacia la vista";
        OrdenDeCompra ord = new OrdenDeCompra();
        List<OrdenDeCompra> lstOrdenDeCompra = new ArrayList<>();
        lstOrdenDeCompra = (List<OrdenDeCompra>) ordenDeCompraDao.findAll();

        model.addAttribute("lstOrdenDeCompra", lstOrdenDeCompra);
        model.addAttribute("ordenDeCompra", ord);
        model.addAttribute("salida", salida);
        return "tables";
    }
    
    @GetMapping("/registroOrdenDeCompra")
    public String registroOrdenDeCompra(OrdenDeCompra ordenDeCompra) {
        return "registroOrdenDeCompra";
    }

    @PostMapping("/guardarOrdenDeCompra")
    public String guardarOrdenDeCompra(OrdenDeCompra ordenDeCompra) {
        ordenDeCompraDao.save(ordenDeCompra);
        return "redirect:tables";
    }

    @RequestMapping("/eliminarOrdenDeCompra")
    public String eliminarOrdenDeCompra(
            @RequestParam(name = "id_orden_de_compra", defaultValue = "0") Integer id_orden_de_compra) {
        ordenDeCompraDao.deleteById(id_orden_de_compra);
        return "redirect:tables";
    }

    @RequestMapping("/modificarOrdenDeCompra")
    public String modificarOrdenDeCompra(
            @RequestParam(name = "id_orden_de_compra", defaultValue = "0") Integer id_orden_de_compra, Model model) {
        OrdenDeCompra ordenDeCompra = ordenDeCompraDao.findById(id_orden_de_compra).orElse(null);
        model.addAttribute("ordenDeCompra", ordenDeCompra);
        return "registroOrdenDeCompra";
    }*/
}
