package com.fluytec.fluytec.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "venta")
public class Venta {

    @Id
    private Integer id_venta;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fec_venta;
    private Integer total_venta;
    private String observacion;
    private Integer vendedor_id_vendedor;

    /*@ManyToOne()
    @JoinColumn(name = "vendedor_id_vendedor")
    private Vendedor vendedor_id_vendedor;*/
    @ManyToMany()
    @JoinTable(name = "venta_productos", joinColumns = @JoinColumn(name = "venta_id_venta"),
            inverseJoinColumns = @JoinColumn(name = "productos_id_productos"))//@JoinTable is used to map Join table in database
    private List<Productos> productos;
}
