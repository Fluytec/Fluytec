package com.fluytec.fluytec.usuario.repository;
import com.fluytec.fluytec.domain.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface usuarioRepository extends PagingAndSortingRepository<Usuario,Long>{
    
}
