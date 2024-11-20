/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EAG
 */
public class GameManager {
    
    private Jugador[] players;
    private Casilla[] squares;
    private Baraja comunityCardDeck;
    private Baraja luckyCardDeck;
    private CuboDados diceCube;
    private Gameboard gameboard;    
    
    private int numSquares;
    
    private int turn;
    private boolean win;
    
    private int activePlayer;
    
    public GameManager(Jugador[] players){
        
        numSquares = 48; // always 48
        
        players = null;
        squares = null;
        comunityCardDeck = new Baraja();
        luckyCardDeck = new Baraja();
        diceCube = null;
        gameboard = new Gameboard(0, 0, 0, 0);
        
        turn = 0;
        win = false;
    }
    
    public void updateTurn(){        
        if (turn == players.length - 1) turn = 0;        
        activePlayer = turn;        
    }
    
    public void manipulateMoney(int money){
        players[activePlayer].setDinero(players[activePlayer].getDinero() + money);
    }    
    public void manipulateMoney(int money, Jugador player){
        player.setDinero(player.getDinero() + money);
    }
    
    public void withdrawPlayersMoney(int money){
        int playerMoney = money / 4;
        
        for (int i = 0; i < players.length; i++) {
            if (i != activePlayer) {
                manipulateMoney(playerMoney, players[i]);
            }else{
                manipulateMoney(money);
            }
        }
    }
    
    public void discountMoneyHouses(){
        int discountHousesPrice = 15;
        int discountHotelPrice = 45;
        
        discountHousesPrice *= players[activePlayer].getNumHouse();
        discountHotelPrice *= players[activePlayer].getNumHotel();
        
        manipulateMoney(-(discountHousesPrice + discountHotelPrice));
    }
    
    
    protected Carta[] createCardDeck(boolean comunidad){
        
        Carta[] cartasAux = new Carta[cartas.length];
        
        String path = "/src/elementos/contenido/cartas"; // no se si va no lo probe
        if (comunidad) path += "Comunidad";
        else path += "Suerte";
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Baraja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File f = new File(path);
        f.
        
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
}
