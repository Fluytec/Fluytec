/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluytec.fluytec.controller;

import com.fluytec.fluytec.domain.MailService;
import com.fluytec.fluytec.domain.SendEmailUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Daniel
 */
@Controller 
public class EmailController {

    @Autowired
    private SendEmailUsuario sendEmailUsuario;

    

    @GetMapping("/editors")
    public String editors() {
        return "editors";
    }

    @PostMapping("/envioCorreos")
    public String envioCorreos(@RequestParam("to") String to, @RequestParam("subject") String subject, @RequestParam("body") String body) {
        String message = body;
        sendEmailUsuario.sendEmailUsuario("danielvargasvelasco@gmail.com", to, subject, message);

        return "editors";
    }
}
