/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas.solo.pruebas.ok;

/**
 *
 * @author jaime
 */
public class PRUEBASSOLOPRUEBASOK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        prueba[] pruebas = new prueba[2];
        pruebas[0] = new prueba(1,(byte) 1, true);
        pruebas[1] = pruebas[0];
        
        System.out.println(pruebas[0] + "\n" + pruebas[1]);
        
        pruebas[1].setA(1283);
        pruebas[0] = null;
        
        System.out.println(pruebas[0] + "\n" + pruebas[1]);

        
        System.out.println("\n" + pruebas[1].getA());
    }
    
}
