package com.fluytec.fluytec.controller;

import com.fluytec.fluytec.domain.MailService;
import com.fluytec.fluytec.domain.SendEmailUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class correosController {

    @Autowired
    private MailService mailService;
    
    @Autowired
    private SendEmailUsuario sendEmailUsuario;

    @GetMapping("/editorss")
    public String editors() {
        return "editors";
    }

   /* @PostMapping("/sendMail")
    public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("body") String body) {

        String message = body + "\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;
        mailService.sendMail("danielvargasvelasco@gmail.com", subject, message);

        return "send_mail_view";
    }*/

}




