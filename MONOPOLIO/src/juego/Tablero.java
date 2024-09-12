/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;


/**
 *
 * @author jaime
 */
public class Tablero {
    
    private Jugador[] jugadores;
    private Casilla[] casillas;
    private Baraja[] barajas;
    private Dado dados;
    
    private Jugador activePlayer;
    
    private int advanceSquares;
    private int timesDiceRolled;
    
    public Tablero(Jugador[] j, Casilla[] c, Baraja b, Baraja ba, Dado d){
        jugadores = j;
        casillas = c;
        barajas = new Baraja[2];
        barajas[0] = b;
        barajas[1] = ba;
        dados = d;
        
        advanceSquares = 0;
        timesDiceRolled = 0;
    }
    
    public void updateTurn(int i){
        activePlayer = jugadores[i];
    }
    
    public void rollDice(){
        int[] results = dados.roll();
        
        advanceSquares += results[0] + results[1];
        timesDiceRolled++;
        
        if (timesDiceRolled == 3) {
            movePlayer(18 /* el que sea la carcel*/);
        }else{
        
            if (results[0] == results[1]) {
                rollDice();
            }

            movePlayer(advanceSquares);
            advanceSquares = 0;
            timesDiceRolled = 0;
        }
        
    }
    
    public void movePlayer(int posicion){
        casillas[posicion].setJugador(activePlayer);
        casillas.
    }

    // GETTERS AND SETTERS //
    
    public Jugador[] getJugadores(){
        return jugadores;
    }
    
    public Casilla[] getCasillas() {
        return casillas;
    }
}
