
package com.fluytec.fluytec.emailController;


import com.fluytec.fluytec.dao.UsuarioDao;
import com.fluytec.fluytec.domain.Usuario;
import com.fluytec.fluytec.servicioMail.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EnviarEmailController {

    @Autowired
    SendMailService sendMailService;

    @Autowired
    UsuarioDao usuarioDao;
    
    @PostMapping("/enviaremail")
    public String enviaremail(@RequestParam("email") String correo /*,
			@RequestParam("subject")String subject,@RequestParam("body") String body*/) {
        Usuario usuarios = usuarioDao.findByCorreo(correo.toLowerCase());
        String mensaje = sendMailService.plantillaCambioContra().
                replace("URL_CAMBIO_CONTRASENA", "http://localhost:8080/formularioCambioContraseña?id_usuarios=" + usuarios.getId_usuarios()).
                replace("nombre_usuario", usuarios.getNombre() + " " + usuarios.getApellido()); //body + "\n\n  correo de contacto;" +subject+"\n asunto"  + "\n email" + correo;
        String subject = "Cambio de contraseña usuario " + usuarios.getNombre() + " " + usuarios.getApellido();
        sendMailService.enviaremail("danielvargasvelasco@gmail.com", correo, subject, mensaje);
        return "/";
    }
    
}



