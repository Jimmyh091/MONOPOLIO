/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;


/**
 *
 * @author jaime
 */
public abstract class Casilla {
    private Jugador jugador;
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    
    public Casilla(int x, int y, int w, int h){
        jugador = null;
        this.x = x;
        this.y = y;
        width = w;
        height = h;
    }
    
    public abstract void interact(Jugador j);
    
    public void setJugador(Jugador j){
        jugador = j;
    }
    public Jugador getJugador() {
        return jugador;
    }
    
}
