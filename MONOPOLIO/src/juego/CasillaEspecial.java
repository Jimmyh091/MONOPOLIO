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
    private Evento evento;
    private Jugador[] players;
    private Casilla[] squares;
    private int type;
    
    public CasillaEspecial(int pX, int pY, String t, int v, int e){
        super(pX, pY);
        titulo = t;
        valor = v;
        players = null;
        squares = null;
        evento = new Evento(e);
        
        type = 0;
    }
    public CasillaEspecial(int pX, int pY, String t, int v, int e, Jugador[] j){
        super(pX, pY);
        titulo = t;
        valor = v;
        players = j;
        squares = null;
        evento = new Evento(e);
        
        type = 1;
    }
    public CasillaEspecial(int pX, int pY, String t, int v, int e, Casilla[] c){
        super(pX, pY);
        titulo = t;
        valor = v;
        players = null;
        squares = c;
        evento = new Evento(e);
        
        type = 2;
    }
    
    @Override
    public void interact(){
        
        switch(type){
            case 0 -> evento.ejecutarEvento(super.getJugador(), valor);
            case 1 -> evento.ejecutarEvento(super.getJugador(), valor, squares);
            case 2 -> evento.ejecutarEvento(super.getJugador(), valor, players);
        }
    }
    
    // GETTERS AND SETTERS //

    public Evento getEvento() {
        return evento;
    }
}