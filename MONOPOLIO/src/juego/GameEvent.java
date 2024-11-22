/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author jaime
 */

/*
tipo 0: el dinero del jugador aumenta/disminuye
tipo 1: el dinero del jugador aumenta porque los jugadores le dan dinero
tipo 2: el dinero del jugador disminuye segun el numero de casas y hoteles
tipo 3: el jugador se teletransporta a una casilla
tipo 4: el jugador recorre el tablero hasta una casilla
*/
@FunctionalInterface
public interface GameEvent {
    public void executeEvent(Jugador j);
}
