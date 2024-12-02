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

    private int id;
    private String nombre;
    private int dinero;
    private int salirCarcel;
    private int tiempoCarcel;
    private boolean inJail;
    private boolean bancarrota;
    
    private int numHouse;
    private int numHotel;
        
    public Jugador(int id, int x, int y, int width, int height, String n, BufferedImage sprite) {
        super(x, y, width, height, sprite);

        this.id = id;
        nombre = n;
        dinero = 1500;
        salirCarcel = 0;
        tiempoCarcel = 0;
        inJail = false;
        bancarrota = false;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
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

    public boolean isInJail() {
        return inJail;
    }
    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }
}