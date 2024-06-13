/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopolio;

/**
 *
 * @author jaime
 */
public class Jugador {
    private byte id;
    private String nombre;
    private int dinero;
    private byte posicion;
    private Carta[] salirCarcel = new Carta[2];
    private byte tiempoCarcel;
    private boolean enCarcel;
    
    public Jugador(byte i, String n){
        id = i;
        nombre = n;
        dinero = 1500;
        posicion = 0;
        for (int j = 0; j < salirCarcel.length; j++) {
            salirCarcel[j] = null;
        }        
        tiempoCarcel = 0;
        enCarcel = false;
    }
    
    public byte tirar(Dado[] dados){
        byte jugada = dados[0].tirar();
        jugada += dados[1].tirar();
        
        return jugada;
    }
}
