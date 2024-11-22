/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualesNuevas;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author EAG
 */
public class MouseHandler implements MouseListener, MouseMotionListener{

    public boolean mouseClicked;
    public boolean mouseMoved;
    public Point clickPosition;
    public Point mousePosition;
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        clickPosition = e.getLocationOnScreen();
        System.out.println("CLICKED");
        mouseClicked = true;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousePosition = e.getLocationOnScreen();
        System.out.println("MOVING");
        mouseMoved = true;
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
