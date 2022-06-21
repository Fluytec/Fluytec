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
@Table(name = "Aux_bodega")
public class Aux_bodega {

    @Id
    private Integer id_aux_bodega;
    private Integer usuarios_id_usuarios;
    
    /*@ManyToOne()
    @JoinColumn(name = "usuarios_id_usuarios")
    private Usuario usuarios_id_usuarios;*/

    /*  @OneToMany(mappedBy = "aux_bodega_id_aux_bodega")
    private List<Inventario> inventario;*/
}
