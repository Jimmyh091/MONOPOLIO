/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaime
 */
public class Baraja {
    private Carta[] cartas;
    private BufferedReader leedor = null;
    private boolean comunidad;
    
    public Baraja(boolean c){
        
        this.comunidad = c;
        
        try {
            leedor = new BufferedReader(new FileReader("src/elementos/contenido/cartas.txt"));
        } catch (FileNotFoundException ex) {
                Logger.getLogger(Baraja.class.getName()).log(Level.SEVERE, null, ex); // copiado ni idea si va
        }
        
        colocarBufferedReader();
        int numCartas = contarCartas();
        
        cartas = new Carta[numCartas];
        String linea;
        int contador = 0;
        
        try {
            leedor = new BufferedReader(new FileReader("src/elementos/contenido/cartas.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Baraja.class.getName()).log(Level.SEVERE, null, ex);
        }
        colocarBufferedReader();
        
        try {
            while(!(linea = leedor.readLine()).isEmpty()){
                String[] datos = linea.split("-");
                
                int cantCartas = Byte.parseByte(datos[0]);
                int evento = Byte.parseByte(datos[1]);
                int valor = Integer.parseInt(datos[3]);
                String desc = datos[2] + datos[3] + datos[4];
                
                String titulo;
                if (comunidad) titulo = "CAJA DE COMUNIDAD";
                else titulo = "CAJA DE SUERTE";
                
                for (int i = 0; i < cantCartas; i++) {
                    cartas[contador] = new Carta(contador, evento, titulo, desc);
                    contador++;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Baraja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void colocarBufferedReader(){
        
        String tipo;
        if (comunidad) tipo = "COMUNIDAD";
        else tipo = "SUERTE";
        
        try {
            do{}while(leedor.readLine().equals(tipo));
            leedor.readLine();
            leedor.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Baraja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private int contarCartas(){
        String linea;
        int numCartas = 0;
        try {
            while(!(linea = leedor.readLine()).isEmpty()){
                numCartas += linea.charAt(0) - '0';
            }
        } catch (IOException ex) {
            Logger.getLogger(Baraja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return numCartas;
    }
    
    public void barajar(){
        for (int i = 0; i < cartas.length; i++) {
            int numAleatorio = (int) (Math.random() * (cartas.length - 1)); // a ver si funciona
            Carta basura = cartas[i];
            cartas[i] = cartas[numAleatorio];
            cartas[numAleatorio] = basura;
        }
    }
    
    public Carta sacarCarta(){
        Carta carta = cartas[cartas.length - 1];
        
        for (int i = cartas.length - 2; i > 0; i--)
            cartas[i + 1] = cartas[i];
        
        cartas[0] = carta;
        
        return carta;
    }
}
