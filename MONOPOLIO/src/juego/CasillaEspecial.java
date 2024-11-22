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
    private GameEvent evento;
    private int type;
    
    public CasillaEspecial(int x, int y, int w, int h, String t, int v, GameEvent e){
        super(x, y, w, h);
        titulo = t;
        valor = v;
        evento = e;
        
        type = 0;
    }
        
    public void interact(){
        evento.executeEvent();
    }
    
    // GETTERS AND SETTERS //

    public GameEvent getEvento() {
        return evento;
    }
}