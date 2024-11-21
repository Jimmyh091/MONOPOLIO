
import java.io.InputStream;
import java.util.ArrayList;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author jaime
 */
public class PRUEBASSOLOPRUEBASOK {

    public PRUEBASSOLOPRUEBASOK(){
        InputStream is = getClass().getResourceAsStream("/contenido/cartasComunidad.txt");
        if (is == null) {
            System.out.println("Recurso no encontrado");
        } else {
            System.out.println("Recurso cargado con éxito");
        }
    }
    public static void main(String[] args) {
        PRUEBASSOLOPRUEBASOK p = new PRUEBASSOLOPRUEBASOK();
        
    }
}
