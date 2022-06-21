package com.fluytec.fluytec.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    private Integer id_usuarios;
    private String nombre;
    private String apellido;
    private Integer identificacion;
    private Integer edad;
    private Integer telefono;
    /*@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)*/
    //private String fec_nacimiento;
    private String correo;
    @Column(name = "contraseña")
    private String clave;

    @ManyToMany()
    @JoinTable(name = "roles_usuarios", joinColumns = @JoinColumn(name = "usuarios_id_usuarios"),
            inverseJoinColumns = @JoinColumn(name = "roles_id_rol"))//@JoinTable is used to map Join table in database
    private List<Rol> roles;


    /*@OneToMany(mappedBy = "usuarios_id_usuarios")
    private List<Administrador> administrador;

    @OneToMany(mappedBy = "usuarios_id_usuarios")
    private List<Vendedor> vendedor;

    @OneToMany(mappedBy = "usuarios_id_usuarios")
    private List<Aux_bodega> aux_bodega;*/
}
/*
        }else if(validar.getRoles().get(0).getNombreRol().equals("Administrador")){
            return"index";
        }else if(validar.getRoles().get(0).getNombreRol().equals("Aux.bodega")){
            return"index-bod";
        }else if(validar.getRoles().get(0).getNombreRol().equals("Vendedor")){
            return"index-ventas";
        }*/
