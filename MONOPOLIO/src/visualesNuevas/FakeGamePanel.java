/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualesNuevas;

import elementosVisuales.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import juego.*;

/**
 *
 * @author jaime
 */
public class FakeGamePanel extends JPanel implements Runnable{
    
    private final int screenWidth = 1366;
    private final int screenHeight = 768;
    private final int FPS = 60;
    
    private Thread gameThread;
    private Thread roundThread;
    private KeyHandler kh;
    
    private GradientPaint background;
    private BufferedImage gameboardImage;
    
    private int selection;
    private int maxSelection;
    
    private int screenState;
    private Button[] titleScreenButtons;
    private Button[] gameScreenButtons;
    private ArrayList<Button[]> screenButtons;
    
    protected FakeGamePanel(){
        
        // AJUSTES
        
        //kh = new KeyHandler();
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.red);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
        
        
        // BOTONES
        titleScreenButtons = new Button[2];
        gameScreenButtons = new Button[1];
        screenButtons = new ArrayList<>();
                
        titleScreenButtons[0] = new Button("button", 10, 100, 40, 0, "Hola",  Color.WHITE, Color.BLACK, null);
        titleScreenButtons[1] = new Button("otherbutton", 120, 100, 40, 0, "Hola", Color.WHITE, Color.BLACK, null);
                
        gameScreenButtons[0] = new Button("otherotherbutton", 10, 100, 40, 0, "Tirar", Color.WHITE, Color.BLACK, null);
        
        screenButtons.add(titleScreenButtons);
        screenButtons.add(gameScreenButtons);
        
        
        // IMAGENES
        
        background = new GradientPaint(0, 0, new Color(100, 255, 100), 0, screenHeight, new Color(200, 255, 200));
        try {
            gameboardImage = ImageIO.read(getClass().getResourceAsStream("/imagenes/pantallaJuego/tablero.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(FakeGamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // VARIABLES
        
        screenState = 0;
        
        selection = -1;
        maxSelection = screenButtons.get(0).length;
        
        startGameThread();
    }

    public void startGameThread(){
        
        gameThread = new Thread(this);
        gameThread.start();
        
        roundThread = new Thread(){
            
            @Override
            public void run(){
                
                // int numPlayers = gameboard.getJugadores().length;
                
                while(gameThread != null){
               //     if (!gameboard.getWin()) {
               //         gameboard.updateTurn();
                //    }
                }
            }
        };
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
            }
        }
    }
    
    public void update(){
        /*
        if (kh.keyPressed) {
            
            String key = kh.getKey();
            
            switch(key){
                case "up" -> {
                    if(selection >= maxSelection) selection = 0;
                    else selection++;
                }
                case "down" -> {
                    if (selection <= 0) selection = maxSelection;
                    else selection--;
                }
                case "left" -> System.out.println("left");
                case "right" -> System.out.println("right");
                case "enter" -> {
                    switch(selection){
                        case 0 -> System.out.println("enter");
                    }
                }
            }
            
            kh.keyPressed = false;
        }

         */
    }
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        // BACKGROUND
        g2.setPaint(background);
        g2.fillRect(0, 0, screenWidth, screenHeight);
        
        // GAMEBOARD
        int boardMargin = (int) (0.1 * screenHeight);
        int boardLength = screenHeight - boardMargin * 2;
        g2.drawImage(gameboardImage, boardMargin, boardMargin / 2, boardLength, boardLength, null);

        //
        
        g2.dispose();
    }
    
    
    // GAME METHODS
    
    private void executeAction(){
        switch(selection){
            // case 0: gameboard.rollDice();
        }
    }
    protected void keyPressed(String key){
        
    }
    
    private Casilla[] crearCasillas(){
        String linea;
        BufferedReader br;
        Casilla[] casillas = null;
        int contador = 0;
        
        try {
            casillas = new Casilla[((int) Files.lines(Paths.get("/elementos/contenido/casillas.txt")).count()) - 0]; //m paths mal
            
            br = new BufferedReader(new FileReader("/elementos/contenido/casillas.txt"));
            
            while((linea = br.readLine()) != null){
                
                if (linea.charAt(0) != '#') {
                    
                    String[] datos = linea.split("/");

                    String clase = datos[0];
                    String titulo = datos[1];
                    int precio = Integer.parseInt(datos[2]);
                    int grupo = Integer.parseInt(datos[3]);

                    int posX = contador * 10;
                    int posY = 10;
                    
                    if (clase.equals("1")) casillas[contador] = new Calle(0,0,0,0, titulo, precio, grupo);
                    else casillas[contador] = new CasillaEspecial(0,0,0,0, titulo, precio, null); // pasando null
                    contador++;                    
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MONOPOLIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return casillas;
    } // temp
    private static Jugador[] crearJugadores(){
        Jugador[] j = new Jugador[4];
        
        for (int i = 0; i < 4; i++) {
            j[i] = new Jugador(i, "" + i);
        }
        
        return j;
    } // temp

}
