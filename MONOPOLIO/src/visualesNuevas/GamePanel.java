/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualesNuevas;

import juego.GameManager;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author EAG
 */
public class GamePanel extends JPanel implements Runnable{
    
    private int screenWidth;
    private int screenHeight;
    private final int FPS = 60;
    
    private Thread gameThread;
    private KeyHandler kh;
    private MouseHandler mh;
    private SceneManager sm;
    private SceneImplementer si;
    private GameManager gm;

    private int selection;
    private int maxSelection;
    private int screenState;
    
    public GamePanel(int sw, int sh){
        
        // SETTINGS
        
        screenWidth = sw;
        screenHeight = sh;
                
        kh = new KeyHandler();
        mh = new MouseHandler();
        gm = new GameManager(null);
        sm = new SceneManager();
        si = new SceneImplementer(gm);

        si.addTest(sm);

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.addMouseListener(mh);
        this.addMouseMotionListener(mh);
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
        
        double drawInterval = (double) 1000000000 / FPS;
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

        System.out.println("sdf");

        if (mh.mouseClicked) {

            System.out.println("CLICKED");

            Point clickPosition = mh.clickPosition;
            sm.checkClickPosition(clickPosition);
            
            mh.mouseClicked = false;
        }
        
        if (mh.mouseMoved) {

            System.out.println("MOVING");

            Point mousePosition = mh.mousePosition;
            
            sm.checkHoverPosition(mousePosition);
            
            mh.mouseMoved = false;
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        sm.paintScene(g2);
    }
    
}
