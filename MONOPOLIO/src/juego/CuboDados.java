/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author EAG
 */
public class CuboDados {
    
    private final int faces;
    private final int numDice;
    
    public CuboDados(int f, int n){
        faces = f;
        numDice = n;
    }
    
    public int[] rollDice(){
        
        int[] result = new int[numDice];
        
        for (int i = 0; i < numDice; i++) {
            result[i] = (int)(Math.random() * faces + 1);
        }
        
        return result;
    }
}
