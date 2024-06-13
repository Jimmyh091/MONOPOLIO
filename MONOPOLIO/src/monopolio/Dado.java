/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopolio;

/**
 *
 * @author jaime
 */
public class Dado {
    private byte tirada;
    
    public Dado(){
        tirada = 0; //???? por poner algo
    }
    
    public byte tirar(){
        return (byte) (Math.random() * (6 - 1) + 1);
    }
}
