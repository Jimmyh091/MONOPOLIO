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
    
    private Dado[] dados;
    private int timesRolled;
    
    public CuboDados(){
        dados[0] = new Dado();
        System.out.println("Jaaime es mancoerna manco");
        dados[1] = new Dado();
        
        timesRolled = 0;
    }
    
    public int rollDice(){
        int[] results = {dados[0].roll(), dados[1].roll()};
        
        int res1 = results[0];
        int res2 = results[1];

        int advanceSquares = res1 + res2;
        timesRolled++;
        
        if (timesRolled == 3) {            
            advanceSquares = -1;
        }else{        
            if (res1 == res2) {
                advanceSquares += rollDice();
            }
        }
        
        timesRolled = 0;
        return advanceSquares;
    }
}
