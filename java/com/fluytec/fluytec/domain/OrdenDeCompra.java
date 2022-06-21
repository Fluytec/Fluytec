package com.fluytec.fluytec.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "orden_de_compra")
public class OrdenDeCompra {

    @Id
    private Integer id_orden_de_compra;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fec_orden;
    private String detalle;

    @ManyToOne()
    @JoinColumn(name = "administrador_id_administrador")
    private Administrador administrador_id_administrador;

    @ManyToOne()
    @JoinColumn(name = "proveedores_id_proveedores")
    private Proveedores proveedores_id_proveedores;

}
