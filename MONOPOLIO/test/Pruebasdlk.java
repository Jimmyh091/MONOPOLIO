
import java.nio.file.Files;
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
    public static void main(String[] args) {
        String rutaArchivo = "src/elementos/contenido/cartasComunidad.txt";
        char caracterEspecifico = '#';

        try {
            List lineas = Files.readAllLines(Paths.get(rutaArchivo));
            long contador = lineas.stream()
                .filter(a -> ((String)a).charAt(0) == caracterEspecifico)
                .count();

            System.out.println("Número de líneas: " + contador);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
