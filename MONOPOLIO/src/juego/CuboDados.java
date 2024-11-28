/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import visualesNuevas.GameUtilities;

import java.awt.image.BufferedImage;

/**
 *
 * @author Jaime
 */
public class CuboDados extends VisualGameElement{
    
    private final int faces;
    private final int numDice;
    private int[] result;
    
    public CuboDados(int x, int y, int width, int height, BufferedImage bi, int f, int n){
        super(x, y, width, height, bi);

        faces = f;
        numDice = n;

        result = new int[numDice];
    }

    public int[] rollDice(){

        for (int i = 0; i < numDice; i++) {
            result[i] = (int)(Math.random() * faces + 1);
        }

        if (GameUtilities.DEBUG) System.out.println("Tirar dados -> Tirada = " + result[0] + ", " + result[1] + " : CuboDados");

        return result;
    }

    public int[] getResult() {
        return result;
    }
}
