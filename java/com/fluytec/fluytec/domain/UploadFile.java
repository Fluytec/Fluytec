package com.fluytec.fluytec.domain;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;

public class UploadFile {

    @Autowired
    Usuario lstUsuarios;

    public List<Usuario> guardarFile(MultipartFile path) throws IOException, CsvValidationException {
        List<Usuario> lstUsuarios = new ArrayList<>();

        String ruta = "C:/cargas/" + path.getOriginalFilename();
        File localFile = new File(ruta);
        path.transferTo(localFile);

        CSVReader csvReader = new CSVReader(new FileReader(ruta));
        String[] fila = null;
        csvReader.readNext();
        while ((fila = csvReader.readNext()) != null) {
            Usuario p = new Usuario();
            p.setId_usuarios(Integer.parseInt(fila[0]));
            p.setNombre(fila[1]);
            p.setApellido(fila[2]);
            p.setIdentificacion(Integer.parseInt(fila[3]));
            p.setEdad(Integer.parseInt(fila[4]));
            p.setTelefono(Integer.parseInt(fila[5]));
            p.setCorreo(fila[6]);
            p.setClave(fila[7]);
            lstUsuarios.add(p);
        }
        csvReader.close();
        return lstUsuarios;
    }
}
