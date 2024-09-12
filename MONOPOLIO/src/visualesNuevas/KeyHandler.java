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

    private String direction;
    
    @Override
    public void keyTyped(KeyEvent e) {
        
        int code = e.getKeyCode();
        switch (code) {
            
            case KeyEvent.VK_KP_UP, KeyEvent.VK_W -> direction = "up";
            case KeyEvent.VK_KP_DOWN, KeyEvent.VK_S -> direction = "down";
            case KeyEvent.VK_KP_LEFT, KeyEvent.VK_A -> direction = "left";
            case KeyEvent.VK_KP_RIGHT, KeyEvent.VK_D -> direction = "right";
            default -> {}
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
