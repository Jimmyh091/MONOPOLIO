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
    private byte numCasas;
    private byte numHoteles;
    
    public Calle(String t, int p, byte g, byte l){
        super();
        titulo = t;
        propietario = null;
        precio = p;
        grupo = g;
        lado = l;
        numCasas = 0;
        numHoteles = 0;
    }
    
    public void alquilar(){
        
    }
    
    public void vender(){
        
    }
    
    public void hipotecar(){
        
    }
    
    public void ponerCasa(){
        
    }

    public Byte getPropietario() {
        return propietario;
    }

    public void setPropietario(Byte propietario) {
        this.propietario = propietario;
    }

    public byte getNumCasas() {
        return numCasas;
    }
    public void setNumCasas(byte numCasas) {
        this.numCasas = numCasas;
    }

    public byte getNumHoteles() {
        return numHoteles;
    }
    public void setNumHoteles(byte numHoteles) {
        this.numHoteles = numHoteles;
    }
    
    
}
