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
    private Evento evento;
    
    public Carta(int i, int id, String t, String d){
        this.id = i;
        evento = new Evento(id);
        propietario = null;
        titulo = t;
        desc = d;
    }
    
    public void ejecutarEvento(int valor){
        evento.ejecutarEvento(propietario, valor);
    }
    
    public void ejecutarEvento(int valor, Casilla[] casillas){
        evento.ejecutarEvento(propietario, valor, casillas);
    }
    
    public void ejecutarEvento(int valor, Jugador[] jugadores){
        evento.ejecutarEvento(propietario, valor, jugadores);
    }

    public Jugador getPropietario() {
        return propietario;
    }
    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }
}
