/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopolio;

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
public class Evento {
    private byte id;
    
    public Evento(byte i){
        id = i;
    }
    
    public void ejecutarEvento(Jugador jugador, int valor){
        switch(id){
            case 0:
                jugador.setDinero(jugador.getDinero() + valor);
                break;
        }
    }
    public void ejecutarEvento(Jugador jugador, int valor, Jugador[] jugadores){
        for (int i = 0; i < jugadores.length; i++) {
            
            if (jugadores[i].getId() != jugador.getId()) {
                
                if (jugadores[i].getDinero() < valor) System.out.println("estas en deuda man jodiste");
                else jugadores[i].setDinero(jugadores[i].getDinero() - valor);                
            }
        }
        
        jugador.setDinero(jugador.getDinero() + valor * (jugadores.length - 1));
    }
    public void ejecutarEvento(Jugador jugador, int valor, Casilla[] casillas){
        byte numCasas = 0;
        byte numHoteles = 0;
        for (int i = 0; i < casillas.length; i++) {
            
            if (casillas[i] instanceof Calle) {
                Calle calle = (Calle) casillas[i];
                
                if (calle.getPropietario() == jugador.getId()) {
                    numCasas += calle.getNumCasas();
                    numHoteles += calle.getNumHoteles();
                }
            }
        }
        int resultado = numCasas * 15 + numHoteles * 75;
        
        jugador.setDinero(jugador.getDinero() - resultado);
    }
}
