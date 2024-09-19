/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jaime
 */
public class Tablero {
    
    private Jugador[] jugadores;
    private Casilla[] casillas;
    private Baraja[] barajas;
    private CuboDados dados;
    
    private Jugador activePlayer;
    
    public Tablero(Jugador[] j){
        jugadores = j;
        casillas = crearCasillas();
        barajas = crearBarajas();
        dados = new CuboDados();
    }
    
    public void updateTurn(int i){
        activePlayer = jugadores[i];
    }
    
    public void movePlayer(int advanceSquares){
        if (advanceSquares == -1) {
            
        }else{
            int finalPosition = activePlayer.getPosicion() + advanceSquares;

            casillas[finalPosition].setJugador(activePlayer);
            casillas[finalPosition].interact();            
        }
        
    }
    public void moveTo(int position){
        casillas[position].setJugador(activePlayer);
        casillas[position].interact();
    }
    public void jumpTo(int position){
        casillas[position].setJugador(activePlayer);
    }

    public static Casilla[] crearCasillas(){
        String linea;
        BufferedReader leedor;
        Casilla[] casillas = null;
        
        try {
            casillas = new Casilla[((int) Files.lines(Paths.get("/elementos/casillas.txt")).count()) - 0];
            
            leedor = new BufferedReader(new FileReader("/elementos/casillas.txt"));
            
            int contador = 0;
            while((linea = leedor.readLine()) != null){
                String[] datos = linea.split("/");
                
                //                                                         0, 0, mal
                if (datos[0].equals("1")) casillas[contador++] = new Calle(0, 0, datos[1], Integer.parseInt(datos[2]), Byte.parseByte(datos[3]));
                else casillas[contador++] = new CasillaEspecial(0, 0, datos[1], Integer.parseInt(datos[2]), Byte.parseByte(datos[3]));
                
            }
        } catch (Exception ex) {
            Logger.getLogger(MONOPOLIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return casillas;
    }
    public static Baraja[] crearBarajas(){
        Baraja[] barajas = {new Baraja(true), new Baraja(false)};
        return barajas;
    }
    
    // GETTERS AND SETTERS //
    
    public Jugador[] getJugadores(){
        return jugadores;
    }
    
    public Casilla[] getCasillas() {
        return casillas;
    }
}
