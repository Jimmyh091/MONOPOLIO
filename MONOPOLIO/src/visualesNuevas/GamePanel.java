/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualesNuevas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import juego.*;

/**
 *
 * @author jaime
 */
public class GamePanel extends JPanel implements Runnable{
    
    private final int screenWidth = 1366;
    private final int screenHeight = 768;
    private final int FPS = 60;
    
    private Thread gameThread;
    private Thread roundThread;
    private KeyHandler kh = new KeyHandler();
    
    private GradientPaint background;
    private BufferedImage gameboardImage;
    
    //private boolean checkKey;
    //private String direction;
    private int selection;
    
    private Tablero gameboard;
    
    protected GamePanel(){
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.red);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
        
        background = new GradientPaint(0, 0, new Color(100, 255, 100), 0, screenHeight, new Color(200, 255, 200));
        try {
            gameboardImage = ImageIO.read(getClass().getResourceAsStream("/elementos/imagenes/pantallaJuego/tablero.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //checkKey = false;
        selection = -1;
        
        // JUEGO - (Jugador[] j, Casilla[] c, Baraja b, Baraja ba, Dado[] d)
        Jugador[] jugador = crearJugadores();
        Casilla[] casillas = crearCasillas();
        Baraja barajaComunidad = new Baraja(true);
        Baraja barajaSuerte = new Baraja(false);
        Dado[] dados = new Dado[2];
        dados[0] = new Dado();
        dados[1] = new Dado();
        
        gameboard = new Tablero(jugador);
        
        startGameThread();
    }

    public void startGameThread(){
        
        gameThread = new Thread(this);
        gameThread.start();
        
        roundThread = new Thread(){
            
            @Override
            public void run(){
                
                int numPlayers = gameboard.getJugadores().length;
                
                while(gameThread != null){
                    for (int i = 0; i < numPlayers; i++) {
                        //gameboard.
                    }
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
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                cronometer = 0;
            }
        }
    }
    public void update(){
        /*if (checkKey) {
            
            switch(direction){
                case
            }
            
            checkKey = false;
        }*/
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
    
    protected void recieveKeyInput(String d){
        //direction = d;
        //checkKey = true;
    }
    
    
    // GAME METHODS
    
    private Casilla[] crearCasillas(){
        String linea;
        BufferedReader leedor;
        Casilla[] casillas = null;
        int contador = 0;
        
        try {
            casillas = new Casilla[((int) Files.lines(Paths.get("src/elementos/contenido/casillas.txt")).count()) - 0];
            
            leedor = new BufferedReader(new FileReader("src/elementos/contenido/casillas.txt"));
            
            while((linea = leedor.readLine()) != null){
                String[] datos = linea.split("/");
                
                int posX = contador * 10;
                int posY = 10;
                
                if (datos[0].equals("1")) casillas[contador] = new Calle(posX, posY, datos[1], Integer.parseInt(datos[2]), Byte.parseByte(datos[3]));
                else casillas[contador] = new CasillaEspecial(posX, posY, datos[1], Integer.parseInt(datos[2]), Byte.parseByte(datos[3]));
                contador++;
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
