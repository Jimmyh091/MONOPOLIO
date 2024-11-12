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
    private int id;
    private Jugador propietario;
    private String titulo;
    private String desc;
    private Event event;
    
    public Carta(int i, String t, String d, Event e){
        id = i;
        propietario = null;
        titulo = t;
        desc = d;
        event = e;
    }
    
    public void executeEvent(){
        event.executeEvent();
    }

    public Jugador getPropietario() {
        return propietario;
    }
    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }
}
