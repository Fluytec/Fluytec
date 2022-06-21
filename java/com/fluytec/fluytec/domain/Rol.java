/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluytec.fluytec.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Rol {

    @Id
    private Integer id_rol;
    private String rol;

    /*@ManyToMany()
    @JoinTable(name="roles_permisos", joinColumns=@JoinColumn(name="roles_id_rol"),
    inverseJoinColumns=@JoinColumn(name="permisos_id_permisos"))//@JoinTable is used to map Join table in database
    private List<Permisos> permisos;*/
}
