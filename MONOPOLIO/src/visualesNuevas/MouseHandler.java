/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualesNuevas;

import javax.swing.*;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author EAG
 */
public class MouseHandler implements MouseListener, MouseMotionListener{

    private GamePanel gamePanel;

    public MouseHandler(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // devuelve el punto en relacion con la ventana no con la pantalla fisica
        gamePanel.getClick(SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), gamePanel));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        gamePanel.getMousePosition(SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), gamePanel));
    }

    // --- //
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }
}
