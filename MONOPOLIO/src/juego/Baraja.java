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
    private String path;
    
    Gameboard gameboard;
    
    public Baraja(String p, Gameboard t){
        
        path = p;
        gameboard = t;
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Baraja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int numCartas = contarCartas();
        cartas = new Carta[numCartas];
    }
    
    private int contarCartas(){
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Baraja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int numCartas = 0;
        String linea;
        
        try{   
            while((linea = br.readLine()) != null) {
                if (linea.charAt(0) != '#') {
                    numCartas++;
                }
            }

        }catch (IOException e){
            System.out.println("No se pudo contar las cartas");
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
