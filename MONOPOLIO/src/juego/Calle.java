/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author jaime
 */
public class Calle extends Casilla{
    private Integer propietario;
    private String titulo;
    private int price1, price2, price3, priceH;    
    private int grupo;
    private int numCasas;
    private int numHoteles;
    
    public Calle(int x, int y, int w, int h, String t, int p, int g){
        super(x, y, w, h);
        titulo = t;
        propietario = null;
        price1 = p;
        price2 = (int) (price1 + price1 * 0.2); //?
        price3 = (int) (price1 + price1 * 0.4);
        priceH = (int) (price1 + price1 * 0.6);
        grupo = g;
        numCasas = 0;
        numHoteles = 0;
    }

    @Override
    public void interact(Jugador j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
