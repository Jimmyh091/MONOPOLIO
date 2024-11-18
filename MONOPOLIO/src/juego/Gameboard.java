/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author EAG
 */
public class Gameboard {
    
    private int x;
    private int y;
    private int width;
    private int height;
     
    private int numSquares;
    
    private Casilla[] casillas;
        
    public Gameboard(int x, int y, int w, int h, int nP){
        
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        
        numSquares = 48;
    }
    
    public void movePlayer(int advanceSquares, Jugador player){
        if (advanceSquares == -1) { // -1 = jail            
            jumpTo(18/*jail square*/, player);
        }else{
            moveTo(player.getPosicion() + advanceSquares, player);
        }        
    }
    
    public void moveTo(int position, Jugador player){
        casillas[position].setJugador(player);
        casillas[position].interact();
    }
    
    public void jumpTo(int position, Jugador player){
        casillas[position].setJugador(player);
    }
    
}
