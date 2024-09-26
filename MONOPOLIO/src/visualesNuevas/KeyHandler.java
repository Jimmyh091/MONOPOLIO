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
        key = "a";
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        switch (code) {
            
            case KeyEvent.VK_KP_UP, KeyEvent.VK_W -> key = "up";
            case KeyEvent.VK_KP_DOWN, KeyEvent.VK_S -> key = "down";
            case KeyEvent.VK_KP_LEFT, KeyEvent.VK_A -> key = "left";
            case KeyEvent.VK_KP_RIGHT, KeyEvent.VK_D -> key = "right";
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
