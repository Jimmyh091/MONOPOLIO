/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopolio;

/**
 *
 * @author jaime
 */
public class Tablero {
    private Jugador[] jugadores;
    private Casilla[] casillas;
    private Carta[] cartas;
    private Evento[] eventos;
    private Dado[] dados;
    
    public Tablero(Jugador[] j, Casilla[] c, Carta[] ca, Evento[] e, Dado[] d){
        jugadores = j;
        casillas = c;
        cartas = ca;
        eventos = e;
        dados = d;
    }
}
