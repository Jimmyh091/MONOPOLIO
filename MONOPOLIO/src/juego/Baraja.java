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
public abstract class Baraja {
    private Carta[] cartas;
    private String path;
    
    public Baraja(String p){
        
        path = p;
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Baraja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int numCartas = contarCartas();
        cartas = new Carta[numCartas];
        
        crearCartas();
    }
    
    private Carta[] crearCartas(){
        
        Carta[] cartasAux = new Carta[cartas.length];
        
        int contador = 0;
        String linea;
        while((linea = br.readLine()) != null){
            String[] datos = linea.split("-");

            int cantCartas = Byte.parseByte(datos[0]);
            int evento = Byte.parseByte(datos[1]);
            String desc1 = datos[2];
            int valor = Integer.parseInt(datos[3]);
            String desc2 = datos[4];

            String desc = desc1 + valor + desc2;

            for (int i = 0; i < cantCartas; i++) {
                // no se porque no utililzo aqui la i del for
                cartas[contador] = new Carta(contador, evento, titulo, desc);
                contador++;
            }
        }
        
        return cartasAux;
    }
    private int contarCartas(){
        
        try {
            BufferedReader brAux = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Baraja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int numCartas = 0;
        
        try{            
            while(!br.readLine().isEmpty()) numCartas++;            
        }catch (IOException e){
            System.out.println("a");
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
