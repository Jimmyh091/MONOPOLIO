/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualesNuevas;

import javax.swing.JPanel;

/**
 *
 * @author EAG
 */
public class RealGamePanel extends JPanel implements Runnable{
    
    private final int screenWidth = 1366;
    private final int screenHeight = 768;
    private final int FPS = 60;
    
    private Thread gameThread;
    private KeyHandler kh;
    private MouseHandler mh;
    
    private int selection;
    private int maxSelection;
    private int screenState;
    
    public RealGamePanel(){
        
        
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
