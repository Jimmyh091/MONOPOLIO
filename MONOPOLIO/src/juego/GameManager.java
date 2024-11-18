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
    private BarajaComunidad comunityCardDeck;
    private BarajaSuerte luckyCardDeck;
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
        comunityCardDeck = new BarajaComunidad();
        luckyCardDeck = new BarajaSuerte();
        diceCube = null;
        gameboard = new Gameboard(0, 0, 0, 0);
        
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
}
