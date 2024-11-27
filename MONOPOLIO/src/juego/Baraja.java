/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import visualesNuevas.GameUtilities;

import java.awt.image.BufferedImage;
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
public class Baraja extends VisualGameElement{
    private Carta[] cards;
    
    public Baraja(int x, int y, int width, int height, BufferedImage bi, Carta[] c){
        super(x, y, width, height, bi);
        cards = c;
    }
        
    public void shuffle(int times){

        if (GameUtilities.DEBUG) System.out.println("Barajar baraja");

        for (int h = 0; h < times; h++) {
            for (int i = 0; i < cards.length; i++) {
                int numAleatorio = (int) (Math.random() * (cards.length - 1)); // a ver si funciona
                Carta basura = cards[i];
                cards[i] = cards[numAleatorio];
                cards[numAleatorio] = basura;
            }            
        }
    }
    
    public Carta drawCard(){

        if (GameUtilities.DEBUG) System.out.println("Sacar carta baraja");

        Carta carta = cards[cards.length - 1];
        
        for (int i = cards.length - 2; i > 0; i--){
            cards[i + 1] = cards[i];
        }
        
        cards[0] = carta;
        //t update observer
        return carta;
    }
}
