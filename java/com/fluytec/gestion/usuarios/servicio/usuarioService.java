
package com.fluytec.gestion.usuarios.servicio;

import com.fluytec.fluytec.domain.Usuario;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface usuarioService{

public List<Usuario>findAll();
public Page<Usuario>findAll(Pageable pageable);
public void save(Usuario usuario);
public Usuario findOne(Long id_usuarios);
public void delete(Long id_usuarios);
}
