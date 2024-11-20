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
    
    protected Carta[] crearCartas(String titulo){
        
        Carta[] cartasAux = new Carta[cartas.length];
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Baraja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int contador = 0;
        String linea;
        
        try {
            while((linea = br.readLine()) != null){
                
                if (linea.charAt(0) != '#') {
                    String[] datos = linea.split("-");

                    int cantCartas = Byte.parseByte(datos[0]);
                    int evento = Byte.parseByte(datos[1]);
                    String desc1 = datos[2];
                    int valor = Integer.parseInt(datos[3]);
                    String desc2 = datos[4];

                    String desc = desc1 + valor + desc2;

                    for (int i = 0; i < cantCartas; i++) {
                        // no se porque no utililzo aqui la i del for
                        
                        Event event = null;
                        
                        switch(evento){
                            case 0 -> event = () -> gameboard.manipulateMoney(valor);
                            case 1 -> event = () -> gameboard.withdrawPlayersMoney(valor);
                            case 2 -> event = () -> gameboard.discountMoneyHouses();
                            case 3 -> event = () -> gameboard.moveTo(valor);
                            case 4 -> event = () -> gameboard.jumpTo(valor);
                            default -> System.out.println("LOG: error.Baraja.crearCartas().switch");
                        }
                        cartas[i] = new Carta(i, titulo, desc, event);
                    }                    
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Baraja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cartasAux;
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
