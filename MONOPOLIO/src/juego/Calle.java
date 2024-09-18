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
public class Calle extends Casilla{
    private String titulo;
    private Byte propietario;
    private int precio;
    private int grupo;
    private int numCasas;
    private int numHoteles;
    
    public Calle(int pX, int pY, String t, int p, int g){
        super(pX, pY);
        titulo = t;
        propietario = null;
        precio = p;
        grupo = g;
        numCasas = 0;
        numHoteles = 0;
    }
    
    public void interact(){
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        boolean opcCubierta;
        
        String menu = "Calle " + titulo +
                "\nPrecio = " + precio +
                "\nGrupo = " + grupo;
        
        if (propietario == null) {
            menu += "\nNadie";
        }else{
            
        }
        
        
        System.out.println(menu);
        
        do {
            boolean datosCorrectos;
            do {
                datosCorrectos = true;
                System.out.println("que quieres hacer?"); // no tiene mucho sentido porque supongo que hare bots pero eso ya pa el tfg
                try{
                    opc = sc.nextByte();                
                }catch (Exception e){
                    datosCorrectos = false;
                    System.out.println("Dato incorrecto");
                }finally{
                    sc.nextLine();                
                }
                
            } while (!datosCorrectos);
            
            opcCubierta = opc >= 0 && opc <= 3; //??
            
            if (!opcCubierta) System.out.println("Tienen que haber entre 2 y 4 jugadores");
            
        } while (!opcCubierta);
    }
    
    public void alquilar(){
        
    }
    
    public void vender(){
        
    }
    
    public void hipotecar(){
        
    }
    
    public void ponerCasa(){
        
    }
    
    // GETTERS AND SETTERS //
    
    public Byte getPropietario() {
        return propietario;
    }
    public void setPropietario(Byte propietario) {
        this.propietario = propietario;
    }

    public int getNumCasas() {
        return numCasas;
    }
    public void setNumCasas(int numCasas) {
        this.numCasas = numCasas;
    }

    public int getNumHoteles() {
        return numHoteles;
    }
    public void setNumHoteles(int numHoteles) {
        this.numHoteles = numHoteles;
    }
}
