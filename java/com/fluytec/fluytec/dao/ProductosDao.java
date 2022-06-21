package com.fluytec.fluytec.dao;

import com.fluytec.fluytec.domain.Productos;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosDao extends JpaRepositoryImplementation<Productos, Integer>{
    
}
