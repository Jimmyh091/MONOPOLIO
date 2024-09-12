/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.awt.Point;

/**
 *
 * @author jaime
 */
public abstract class Casilla {
    private Jugador jugador;
    private final int posX;
    private final int posY;
    private Point a;
    
    public Casilla(int pX, int pY){
        jugador = null;
        posX = pX;
        posY = pY;
    }
    
    public abstract void interact();
    
    public void setJugador(Jugador j){
        jugador = j;
    }
    public Jugador getJugador() {
        return jugador;
    }
    
}
