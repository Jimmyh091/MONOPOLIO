/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualesNuevas;

import juego.GameManager;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Jaime
 */
public class GamePanel extends JPanel implements Runnable{
    
    public static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    private final int FPS = 60;
    private boolean keyPressed;
    private boolean clickRecieved;
    private boolean mouseMovedRecieved;
    private String key;
    private Point clickPosition;
    private Point mousePosition;

    private VisualManager vm;
    private SceneManager sm;
    
    private Thread gameThread;

    private int selection;
    private int maxSelection;
    private int screenState;
    
    public GamePanel(){
        
        // SETTINGS
        sm = new SceneManager();
        vm = new VisualManager(sm);

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        
        
        // VARIABLES
        
        screenState = 0;
        selection = -1; // when hit, set to 0
        maxSelection = 0; //todo
        
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
                if (GameUtilities.FPS) System.out.println("FPS: " + drawCount);
                drawCount = 0;
                cronometer = 0;
            }
        }
        
    }
    
    public void update(){
        if (keyPressed) {

            switch(key){
                case "up" -> System.out.println("No implementado");
                case "down" -> System.out.println("No implementado");
                case "left" -> System.out.println("No implementado");
                case "right" -> System.out.println("No implementado");
                
                case "enter" -> System.out.println("No implementado");
                case "escape" -> System.out.println("No implementado");
            }
            
            keyPressed = false;
        }

        if (clickRecieved) {

            if (GameUtilities.CLICK_POSITION){ System.out.println("Click en: " + clickPosition.x + ", " + clickPosition.y); }

            sm.checkClickPosition(clickPosition);
            
            clickRecieved = false;
        }
        
        if (mouseMovedRecieved) {

            if (GameUtilities.MOUSE_POSITION) { System.out.println("Raton en: " + mousePosition.x + ", " + mousePosition.y); }

            sm.checkHoverPosition(mousePosition);
            
            mouseMovedRecieved = false;
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        sm.paintScene(g2);

        g.dispose(); //? no se si tendria que usarlo
    }

    public synchronized void getKey(String key){
        this.key = key;
        keyPressed = true;
    }

    public synchronized void getClick(Point p){
        clickPosition = p;
        clickRecieved = true;
    }

    public synchronized void getMousePosition(Point p){
        mousePosition = p;
        mouseMovedRecieved = true;
    }
}
