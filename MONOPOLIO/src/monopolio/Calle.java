/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopolio;

/**
 *
 * @author jaime
 */
public class Calle extends Casilla{
    private String titulo;
    private Byte propietario;
    private int precio;
    private byte grupo;
    private byte lado;
    
    public Calle(String t, int p, byte g, byte l){
        super();
        titulo = t;
        propietario = null;
        precio = p;
        grupo = g;
        lado = l;
    }
}
