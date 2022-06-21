package com.fluytec.fluytec.dao;

import com.fluytec.fluytec.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Integer>{
   // public Usuario findById_usuariosAndClave(Integer id_usuarios, String clave);
   @Query(value ="SELECT * FROM usuarios WHERE id_usuarios=?1 and contraseña=?2", nativeQuery = true )
  public Usuario iniciarSesion(Integer id_usuarios, String clave);
  
    @Query(value = "select A.* from usuarios A \n"
            + "LEFT JOIN roles_usuarios B ON (A.id_usuarios = B.usuarios_id_usuarios)\n"
            + "LEFT JOIN vendedor C ON (A.id_usuarios = C.usuarios_id_usuarios)\n"
            + "RIGHT JOIN administrador D ON (A.id_usuarios = D.usuarios_id_usuarios)\n"
            + "RIGHT JOIN aux_bodega E ON (A.id_usuarios = E.usuarios_id_usuarios)\n"
            + "WHERE B.usuarios_id_usuarios is null, C.usuarios_id_usuarios is null, D.usuarios_id_usuarios is null and E.usuarios_id_usuarios is null", nativeQuery = true)
    public List<Usuario> eliminarUsuario();
    
   /* public void deleteById(Integer id_usuarios);

    public Object findById();

    public Object findById(Integer id_usuarios);*/
    @Query(value="select * from usuario where correo=?1", nativeQuery= true)
    public Usuario findByCorreo(String Correo);
}
        