package com.fluytec.fluytec.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "proveedores")
public class Proveedores {

    @Id
    private Integer id_proveedores;
    private String nom_proveedor;

    @OneToMany(mappedBy = "proveedores_id_proveedores")
    private List<OrdenDeCompra> OrdenDeCompra;

    /*@ManyToMany(mappedBy = "Proveedores")
    private Set<Productos> productos;*/
}
