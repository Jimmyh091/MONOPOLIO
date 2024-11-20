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
    private Carta[] cards;
    
    public Baraja(Carta[] c){
        cards = c;
    }
        
    public void shuffle(int times){
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
        Carta carta = cards[cards.length - 1];
        
        for (int i = cards.length - 2; i > 0; i--){
            cards[i + 1] = cards[i];
        }
        
        cards[0] = carta;
        
        return carta;
    }
}
