/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.util.Scanner;

/**
 *
 * @author jaime
 */
public class Jugador {
    private final int id;
    
    private int x, y;
    
    private String nombre;
    private int dinero;
    private int posicion;
    private boolean[] salirCarcel;
    private int tiempoCarcel;
    private boolean bancarrota;
    
    public Jugador(int i, String n){
        id = i;
        x = 0; 
        y = 0;
        nombre = n;
        dinero = 1500;
        posicion = 0;
        salirCarcel = new boolean[2];
        for (int j = 0; j < salirCarcel.length; j++) {
            salirCarcel[j] = false;
        }        
        tiempoCarcel = 0;
        bancarrota = false;
    }
    
    public void tirar(Dado[] dados, int veces, int tirada){
        /*if (veces == 3) {
            System.out.println("pa la carsel");
            posicion = 20; // no es esta creo supongo
        }else{
            System.out.println("Pulsa enter para tirar");

            int jugada1 = dados[0].tirar();
            int jugada2 = dados[1].tirar();
            System.out.println(jugada1 + " y " + jugada2);

            int jugada = (int) (jugada1 + jugada2);

            if (jugada1 == jugada2) {
                System.out.println("Parejas!");
                tirar(dados, ++veces, (tirada += jugada1 + jugada2));
            }
            
            posicion += tirada;
            if (posicion > 48 ultima casilla){
                posicion -= 48;
                pasarPorSalida();
            }
        }*/

    }

    private void pasarPorSalida(){
        System.out.println("Pasas por la salida, +200€");
        dinero += 200;
    }
    
    // GETTERS AND SETTERS //
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }

    public int getDinero() {
        return dinero;
    }
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    
    public boolean getBancarrota(){
        return bancarrota;
    }
    
    public int getPosicion(){
        return posicion;
    }
    public void setPosicion(int p){
        posicion = p;
    }
}