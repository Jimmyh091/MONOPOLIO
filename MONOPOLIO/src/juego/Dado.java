/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author jaime
 */
public class Dado {
    
    private int result;
    
    public Dado(){
        result = 0;
    }
    
    public int roll(){
        return (int) (Math.random() * (6 - 1) + 1);
    }
}
