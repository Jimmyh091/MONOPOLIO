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
    
    private int x, y, w, h;
    
    private String nombre;
    private int dinero;
    private int posicion;
    private int salirCarcel;
    private int tiempoCarcel;
    private boolean bancarrota;
    
    private int numHouse;
    private int numHotel;
        
    public Jugador(int i, String n){
        id = i;
        x = 0; 
        y = 0;
        nombre = n;
        dinero = 1500;
        posicion = 0;
        salirCarcel = 0;
        tiempoCarcel = 0;
        bancarrota = false;
    }

    public int getDinero() {
        return dinero;
    }
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    public boolean getBancarrota(){
        return bancarrota;
    }

    public int getNumHouse() {
        return numHouse;
    }
    public void setNumHouse(int numHouse) {
        this.numHouse = numHouse;
    }

    public int getNumHotel() {
        return numHotel;
    }
    public void setNumHotel(int numHotel) {
        this.numHotel = numHotel;
    }
}