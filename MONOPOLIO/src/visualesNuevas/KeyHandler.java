/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualesNuevas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author jaime
 */
public class KeyHandler implements KeyListener{

    protected boolean keyPressed;
    private String key;
    
    public KeyHandler(){
        keyPressed = false;
        key = "";
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        switch (code) {
            
            case KeyEvent.VK_UP, KeyEvent.VK_W -> key = "up";
            case KeyEvent.VK_DOWN, KeyEvent.VK_S -> key = "down";
            case KeyEvent.VK_LEFT, KeyEvent.VK_A -> key = "left";
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> key = "right";
            
            /*
            case KeyEvent.VK_B -> key = "b";
            case KeyEvent.VK_C -> key = "c";
            case KeyEvent.VK_E -> key = "e";
            case KeyEvent.VK_F -> key = "f";
            case KeyEvent.VK_G -> key = "g";
            case KeyEvent.VK_H -> key = "h";
            case KeyEvent.VK_I -> key = "i";
            case KeyEvent.VK_J -> key = "j";
            case KeyEvent.VK_K -> key = "k";
            case KeyEvent.VK_L -> key = "l";
            case KeyEvent.VK_M -> key = "m";
            case KeyEvent.VK_N -> key = "n";
            case KeyEvent.VK_O -> key = "o";
            case KeyEvent.VK_P -> key = "p";
            case KeyEvent.VK_Q -> key = "q";
            case KeyEvent.VK_R -> key = "r";
            case KeyEvent.VK_T -> key = "t";
            case KeyEvent.VK_U -> key = "u";
            case KeyEvent.VK_V -> key = "v";
            case KeyEvent.VK_X -> key = "x";
            case KeyEvent.VK_Y -> key = "y";
            case KeyEvent.VK_Z -> key = "z";            
            case KeyEvent.VK_0 -> key = "0";
            case KeyEvent.VK_1 -> key = "1";
            case KeyEvent.VK_2 -> key = "2";
            case KeyEvent.VK_3 -> key = "3";
            case KeyEvent.VK_4 -> key = "4";
            case KeyEvent.VK_5 -> key = "5";
            case KeyEvent.VK_6 -> key = "6";
            case KeyEvent.VK_7 -> key = "7";
            case KeyEvent.VK_8 -> key = "8";
            case KeyEvent.VK_9 -> key = "9";
            */
            
            case KeyEvent.VK_ESCAPE -> key = "escape";
            case KeyEvent.VK_SPACE -> key = "space";
            case KeyEvent.VK_ENTER -> key = "enter";
        }
        
        keyPressed = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    protected String getKey(){
        return key;
    }
}
