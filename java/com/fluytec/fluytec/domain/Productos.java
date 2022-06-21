package com.fluytec.fluytec.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")

public class Productos {

    @Id
    private Integer id_productos;
    private String nom_productos;
    private Integer num_productos;
    private Integer precio;
    private Integer inventario_id_inventario;

    @ManyToMany()
    @JoinTable(name = "productos_proveedores", joinColumns = @JoinColumn(name = "productos_id_productos"),
            inverseJoinColumns = @JoinColumn(name = "proveedores_id_proveedores"))//@JoinTable is used to map Join table in database
    private List<Proveedores> proveedores;

    @ManyToMany()
    @JoinTable(name = "productos_inventario", joinColumns = @JoinColumn(name = "productos_id_productos"),
            inverseJoinColumns = @JoinColumn(name = "inventario_id_inventario"))//@JoinTable is used to map Join table in database
    private List<Inventario> inventario;

    /* @ManyToMany(mappedBy = "Productos")
    private Set<Venta> venta;*/
}
