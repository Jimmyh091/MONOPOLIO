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
    private Event event;
    
    public Carta(String t, String d, Event e){
        titulo = t;
        desc = d;
        event = e;
    }
    
    public void executeEvent(){
        event.executeEvent();
    }
}
