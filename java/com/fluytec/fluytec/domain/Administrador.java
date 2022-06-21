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
@Table(name = "Administrador")
public class Administrador {

    @Id
    private Integer id_adminstrador;
    private Integer usuarios_id_usuarios;

    @OneToMany(mappedBy = "administrador_id_administrador")
    private List<OrdenDeCompra> orden_de_compra;

   /* @ManyToOne()
    @JoinColumn(name = "usuarios_id_usuarios")
    private Usuario usuarios_id_usuarios;*/
}
