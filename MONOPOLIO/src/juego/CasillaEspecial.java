/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author jaime
 */
public class CasillaEspecial extends Casilla{
    
    private String titulo;
    private int valor;
    private Event evento;
    private int type;
    
    public CasillaEspecial(int x, int y, int w, int h, String t, int v, Event e){
        super(x, y, w, h);
        titulo = t;
        valor = v;
        evento = e;
        
        type = 0;
    }
    
    @Override
    public void interact(){
        evento.executeEvent();
    }
    
    // GETTERS AND SETTERS //

    public Event getEvento() {
        return evento;
    }
}