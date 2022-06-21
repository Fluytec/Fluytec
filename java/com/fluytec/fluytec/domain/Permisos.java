package com.fluytec.fluytec.domain;

import java.sql.Time;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "Permisos")
public class Permisos {

    @Id
    private Integer id_permisos;
    private Integer descripcion_permiso;

    /* @ManyToMany(mappedBy = "Permisos")
    private Set<Rol> roles;*/
}
