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
public class BarajaComunidad extends Baraja{
    
    public BarajaComunidad(String p, Tablero t){
        super(p, t);
        super.crearCartas("CAJA DE LA COMUNIDAD");
    }
}
