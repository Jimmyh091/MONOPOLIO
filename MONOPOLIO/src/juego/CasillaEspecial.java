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
public class CasillaEspecial extends Casilla{
    
    private String titulo;
    private int valor;
    private GameEvent evento;
    private int type;
    
    public CasillaEspecial(int x, int y, int w, int h, BufferedImage bi, String t, int v, GameEvent e){
        super(x, y, w, h, bi);

        titulo = t;
        valor = v;
        evento = e;
        
        type = 0; //? no es necesario
    }
        
    public void interact(Jugador j){

        if (GameUtilities.DEBUG) System.out.println("Interactuar : CasillaEspecial");

        evento.executeEvent(j);
    }
    
    // GETTERS AND SETTERS //

    public GameEvent getEvento() {
        return evento;
    }
}