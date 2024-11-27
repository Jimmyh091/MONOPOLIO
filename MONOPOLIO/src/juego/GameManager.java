/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import visualesNuevas.GameUtilities;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
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
        comunityCardDeck = new Baraja(0, 0, 0, 0, null, createCardDeck(true));
        luckyCardDeck = new Baraja(0, 0, 0, 0, null, createCardDeck(false));
        diceCube = new CuboDados(0, 0, 0, 0, null, 6, 2);
        gameboard = new Gameboard(0, 0, 0, 0, null);
        
        turn = 0;
        win = false;
    }
    
    public void updateTurn(){        
        if (turn == players.length - 1) turn = 0;        
        activePlayer = turn;

        if (GameUtilities.DEBUG) System.out.println("Actualizar turnos");

    }
    
    public void rollDice(){

        if (GameUtilities.DEBUG) System.out.println("Tirar dados : GameManager");

        int result = getDiceResult(0, 0);
    }
    
    public int getDiceResult(int times, int r){
        
        int result = 0;
        
        for (int i = 0; i < 3; i++) {            
            int[] diceResult = diceCube.rollDice();
            result += diceResult[0] + diceResult[1];
            
            if (diceResult[0] == diceResult[1]) {
                if (i == 3) {

                    if (GameUtilities.DEBUG) System.out.println("Se va a la carcel");

                    return -1; // significa ir a la carcel
                }   
            }else{

                if (GameUtilities.DEBUG) System.out.println("Tirada: " + result);

                return result;
            }
        }
        
        return 0; // nunca llega
        
    }
    
    public void manipulateMoney(int money){
        players[activePlayer].setDinero(players[activePlayer].getDinero() + money);
    }    
    public void manipulateMoney(int money, Jugador player){
        player.setDinero(player.getDinero() + money);
    }
    
    public void withdrawPlayersMoney(int money, Jugador j){
        int playerMoney = money / 4;
        
        for (int i = 0; i < players.length; i++) {
            if (i != activePlayer) {
                manipulateMoney(playerMoney, players[i]);
            }else{
                manipulateMoney(money);
            }
        }
    }
    
    public void discountMoneyHouses(Jugador j){
        int discountHousesPrice = 15;
        int discountHotelPrice = 45;
        
        discountHousesPrice *= players[activePlayer].getNumHouse();
        discountHotelPrice *= players[activePlayer].getNumHotel();
        
        manipulateMoney(-(discountHousesPrice + discountHotelPrice));
    }
    
    private int countFileLines(String path, char commentCharacter){
        
        int contador = 0;

        try {
            Path p = Paths.get(getClass().getResource(path).toURI());

            List lineas = Files.readAllLines(Paths.get(getClass().getResource(path).toURI()));
            contador = (int) lineas.stream()
                .filter(a -> ((String)a).charAt(0) != commentCharacter)
                .count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return contador;
    }
    
    private GameEvent createEvent(int event, int valor){
        switch(event){
            case 0 -> {
                return (Jugador j) -> manipulateMoney(valor, j);
            }

            case 1 -> {
                return (Jugador j) -> withdrawPlayersMoney(valor, j);
            }

            case 2 -> {
                return this::discountMoneyHouses;
            }

            case 3 -> {
                return (Jugador j) -> gameboard.moveTo(valor, j);
            }

            case 4 -> {
                return (Jugador j) -> gameboard.jumpTo(valor, j);
            }

            default -> System.out.println("Error");

        }
        
        return null; // no deberia llegar nunca
    }
    
    protected Carta[] createCardDeck(boolean comunidad){

        String path = "/contenido/cartas"; // no se si va no lo probe
        if (comunidad) path += "Comunidad.txt";
        else path += "Suerte.txt";
        
        Carta[] cards = new Carta[countFileLines(path, '#')];
        
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(new File(getClass().getResource(path).toURI())));
        } catch (FileNotFoundException | URISyntaxException ex) {
            Logger.getLogger(Baraja.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        String linea;        
        try {
            while((linea = br.readLine()) != null){
                
                if (linea.charAt(0) != '#') {
                    String[] datos = linea.split("-");

                    int cantCartas = Byte.parseByte(datos[0]);
                    int event = Byte.parseByte(datos[1]);
                    
                    String desc1 = datos[2];
                    String desc2 = datos[4];
                    int valor = Integer.parseInt(datos[3]);

                    String desc = desc1 + valor + desc2;

                    String titulo = (comunidad) ? "COMUNIDAD" : "SUERTE";


                    for (int i = 0; i < cards.length; i++) {

                        GameEvent eventAux = createEvent(event, valor);

                        cards[i] = new Carta(0, 0, 0, 0, null, titulo, desc, eventAux);

                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Baraja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cards;
    }

    public Jugador[] getPlayers() {
        return players;
    }
    public Casilla[] getSquares() {
        return squares;
    }

    public Baraja getComunityCardDeck() {
        return comunityCardDeck;
    }
    public Baraja getLuckyCardDeck() {
        return luckyCardDeck;
    }

    public CuboDados getDiceCube() {
        return diceCube;
    }
    public Gameboard getGameboard() {
        return gameboard;
    }
}
