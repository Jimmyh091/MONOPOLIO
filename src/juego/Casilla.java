/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;


import visualesNuevas.GameUtilities;

import java.awt.image.BufferedImage;

/**
 *
 * @author jaime
 */
public abstract class Casilla extends VisualGameElement {
    private Jugador jugador;
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    
    public Casilla(int x, int y, int w, int h, BufferedImage bi) {
        super(x, y, w, h, bi); //t

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
