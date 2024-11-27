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
public class Carta extends VisualGameElement{
    private String titulo;
    private String desc;
    private GameEvent gameEvent;
    
    public Carta(int x, int y, int width, int height, BufferedImage bi, String t, String d, GameEvent e){
        super(x, y, width, height, bi);
        titulo = t;
        desc = d;
        gameEvent = e;
    }
    
    public void executeEvent(Jugador j){

        if (GameUtilities.DEBUG) System.out.println("Ejecutar evento : Carta");

        gameEvent.executeEvent(j);
    }
}
