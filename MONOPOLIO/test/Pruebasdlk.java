
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EAG
 */
public class Pruebasdlk {

    public Pruebasdlk() {

        boolean comunidad = false;

        String path = "contenido/cartas"; // no se si va no lo probe
        if (comunidad) path += "Comunidad.txt";
        else path += "Suerte.txt";

        Path p = null;
        try {
            p = Paths.get(getClass().getResource(path).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

        new Pruebasdlk();

        /*
        String rutaArchivo = "/resources/contenido/cartasComunidad.txt";
        char caracterEspecifico = '#';

        try {
            List lineas = Files.readAllLines(Paths.get(rutaArchivo));
            long contador = lineas.stream()
                .filter(a -> ((String)a).charAt(0) == caracterEspecifico)
                .count();

            System.out.println("Número de líneas: " + contador);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
