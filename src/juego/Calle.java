/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import visualesNuevas.GameUtilities;

import java.awt.image.BufferedImage;

/**
 *
 * @author jaime
 */
public class Calle extends Casilla{
    private Integer propietario;
    private int price1, price2, price3, priceH;    
    private int grupo;
    private int numCasas;
    private int numHoteles;
    
    public Calle(int x, int y, int w, int h, BufferedImage bi, String t, int p, int g){
        super(x, y, w, h, bi, t);

        propietario = null;
        price1 = p;
        price2 = (int) (price1 + price1 * 0.2); //t
        price3 = (int) (price1 + price1 * 0.4);
        priceH = (int) (price1 + price1 * 0.6);
        grupo = g;
        numCasas = 0;
        numHoteles = 0;
    }

    @Override
    public void interact(Jugador j) {

        if (GameUtilities.DEBUG) System.out.println("Interactuar : Calle");

        throw new UnsupportedOperationException("Not supported yet."); //t
    }

    public int getPrice1() {
        return price1;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public int getPrice2() {
        return price2;
    }

    public void setPrice2(int price2) {
        this.price2 = price2;
    }

    public int getPrice3() {
        return price3;
    }

    public void setPrice3(int price3) {
        this.price3 = price3;
    }

    public int getPriceH() {
        return priceH;
    }

    public void setPriceH(int priceH) {
        this.priceH = priceH;
    }
}
