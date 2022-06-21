package com.fluytec.fluytec.dao;

import com.fluytec.fluytec.domain.Inventario;
import org.springframework.data.repository.CrudRepository;

public interface InventarioDao extends CrudRepository<Inventario, Integer>{
    
}
