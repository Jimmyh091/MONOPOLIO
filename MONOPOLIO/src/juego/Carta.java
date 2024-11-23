/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author jaime
 */
public class Carta {
    private String titulo;
    private String desc;
    private GameEvent gameEvent;
    
    public Carta(String t, String d, GameEvent e){
        titulo = t;
        desc = d;
        gameEvent = e;
    }
    
    public void executeEvent(Jugador j){
        gameEvent.executeEvent(j);
    }
}
