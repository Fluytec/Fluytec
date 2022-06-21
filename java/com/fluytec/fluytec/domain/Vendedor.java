package com.fluytec.fluytec.domain;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "Vendedor")
public class Vendedor {

    @Id
    private Integer id_vendedor;
    private Integer usuarios_id_usuarios;
    
    /*@ManyToOne()
    @JoinColumn(name = "usuarios_id_usuarios")
    private Usuario usuarios_id_usuarios;*/

    /*@OneToMany(mappedBy = "vendedor_id_vendedor")
    private List<Venta> venta;*/
}
