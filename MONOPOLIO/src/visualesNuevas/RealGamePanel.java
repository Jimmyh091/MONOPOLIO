/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualesNuevas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author EAG
 */
public class RealGamePanel extends JPanel implements Runnable{
    
    private int screenWidth = 1366;
    private int screenHeight;
    private final int FPS = 60;
    
    private Thread gameThread;
    private KeyHandler kh;
    private MouseHandler mh;
    
    private int selection;
    private int maxSelection;
    private int screenState;
    
    public RealGamePanel(int sw, int sh){
        
        // SETTINGS
        
        screenWidth = sw;
        screenHeight = sh;
                
        kh = new KeyHandler();
        mh = new MouseHandler();
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.addMouseListener(mh);
        this.setFocusable(true);
        
        
        // VARIABLES
        
        screenState = 0;
        selection = -1; // when hit, set to 0
        maxSelection = 0; //t
        
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() {
        
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        long cronometer = 0;
        int drawCount = 0;
        
        while(gameThread != null){
            
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            cronometer += currentTime - lastTime;
            lastTime = currentTime;
            
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;                
            }
            
            if (cronometer >= 1000000000) {
                drawCount = 0;
                cronometer = 0;
                System.out.println("FPS: " + drawCount);
            }
        }
        
    }
    
    public void update(){
        if (kh.keyPressed) {
            
            String key = kh.getKey();
            
            switch(key){
                case "up" -> System.out.println("No implementado");
                case "down" -> System.out.println("No implementado");
                case "left" -> System.out.println("No implementado");
                case "right" -> System.out.println("No implementado");
                
                case "enter" -> System.out.println("No implementado");
                case "escape" -> System.out.println("No implementado");
            }
            
            kh.keyPressed = false;
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
    }
    
}
