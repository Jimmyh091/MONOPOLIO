/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.awt.image.BufferedImage;
import java.util.Scanner;

/**
 *
 * @author jaime
 */
public class Jugador extends VisualGameElement{
    
    private String nombre;
    private int dinero;
    private int posicion;
    private int salirCarcel;
    private int tiempoCarcel;
    private boolean bancarrota;
    
    private int numHouse;
    private int numHotel;
        
    public Jugador(int x, int y, int width, int height, String n, BufferedImage sprite) {
        super(x, y, width, height, sprite);

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