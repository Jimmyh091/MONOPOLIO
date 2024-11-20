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
    
    private int faces;
    private int numDice;
    
    public CuboDados(int f, int n){
        faces = f;
        numDice = n;
    }
    
    public int[] rollDice(){
        return new int[]{
            (int)(Math.random() * faces + 1), 
            (int)(Math.random() * faces + 1)};
    }
}
