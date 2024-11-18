/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.io.BufferedReader;

/**
 *
 * @author EAG
 */
public class GameManager {
    
    private Jugador[] players;
    private Casilla[] squares;
    private Baraja[] cardDeck;
    private CuboDados diceCube;
    
    private int numSquares;
    
    private int turn;
    private boolean win;
    
    private int activePlayer;
    
    public GameManager(Jugador[] players){
        
        numSquares = 48; // always 48
        
        players = null;
        squares = null;
        cardDeck = null;
        diceCube = null;
        
        turn = 0;
        win = false;
    }
    
    public void updateTurn(){        
        if (turn == players.length - 1) turn = 0;        
        activePlayer = turn;        
    }
    
    public int rollDice(){
        return diceCube.rollDice();
    }
    
    public static Baraja[] crearBarajas(Tablero1 t){
        Baraja[] barajas = {new BarajaComunidad("src/elementos/contenido/cartasComunidad.txt", t), new BarajaSuerte("src/elementos/contenido/cartasComunidad.txt", t)};
        return barajas;
    }
}
