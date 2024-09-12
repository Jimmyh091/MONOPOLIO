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
    
    private int[] result;
    
    public Dado(){
        result = new int[2];
    }
    
    public int[] roll(){
        
        result = new int[2];
        
        result[0] = (int) (Math.random() * (6 - 1) + 1);
        result[1] = (int) (Math.random() * (6 - 1) + 1);
        
        return result;
    }
}
