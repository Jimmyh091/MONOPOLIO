/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.awt.Dimension;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jaime
 */
public class Tablero {
    
    private int x;
    private int y;
    private int width;
    private int height;
    
    private int innerX;
    private int innerY;
    private int innerWidth;
    private int innerHeight;
    
    private int numSquares;
    
    private Jugador[] jugadores;
    private Casilla[] casillas;
    private Baraja[] barajas;
    private CuboDados dados;
    
    private int turn;
    private boolean win;
    
    private Jugador activePlayer;
    
    
    public Tablero(Jugador[] j, int x, int y, int w, int h){
        
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        
        asignInnerCoords();
        
        
        
        numSquares = 48;
        
        jugadores = j;
        casillas = crearCasillas();
        barajas = crearBarajas();
        dados = new CuboDados();
        
        turn = 0;
        win = false;
    }
    
    public void updateTurn(){
        
        if (turn == jugadores.length - 1) turn = 0;        
        activePlayer = jugadores[turn];
        
    }
    
    public void movePlayer(int advanceSquares){
        if (advanceSquares == -1) {
            // Si es -1, lo mandas a la carcel
            jumpTo(18);
        }else{
            moveTo(activePlayer.getPosicion() + advanceSquares);
        }        
    }    
    public void moveTo(int position){
        casillas[position].setJugador(activePlayer);
        casillas[position].interact();
    }
    public void jumpTo(int position){
        casillas[position].setJugador(activePlayer);
    }

    public void rollDice(){
        int advanceSquares = rollDiceOnly();
        System.out.println(advanceSquares);
    }
    
    public int rollDiceOnly(){
        return dados.rollDice();
    }
    
    public static Casilla[] crearCasillas(){
        BufferedReader leedor;
        Casilla[] casillas = null;
        
        Point[] puntos = asignPoints();

        String linea;
        try {
            casillas = new Casilla[((int) Files.lines(Paths.get("src/elementos/contenido/casillas.txt")).count()) - 0];
            
            leedor = new BufferedReader(new FileReader("src/elementos/contenido/casillas.txt"));
            
            int contador = 0;
            while((linea = leedor.readLine()) != null){
                if (linea.charAt(0) != '#') {
                    String[] datos = linea.split("/");

                    //                                                         0, 0, mal
                    if (datos[0].equals("1")) casillas[contador++] = new Calle(0, 0, datos[1], Integer.parseInt(datos[2]), Byte.parseByte(datos[3]));
                    else casillas[contador++] = new CasillaEspecial(0, 0, datos[1], Integer.parseInt(datos[2]), Byte.parseByte(datos[3]));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MONOPOLIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return casillas;
    }
    public static Baraja[] crearBarajas(){
        Baraja[] barajas = {new BarajaComunidad("src/elementos/contenido/cartasComunidad.txt"), new BarajaSuerte("src/elementos/contenido/cartasComunidad.txt")};
        return barajas;
    }
    
    private void asignInnerCoords(int percentage){
        int sideLength = width - x;
        int innerSideLength = sideLength * (percentage / 100);
        
        int margin = (sideLength - innerSideLength) / 2;
        
        innerX = x + margin;
        innerY = y + margin;
        innerWidth = width - margin;
        innerHeight = height - margin;
    }
    
    private Point[][] asignPoints(){
        Point[] points = new Point[numSquares];
        Point[] lengths = new Point[numSquares];
        
        // Just a quarter of the total squares in the table
        int quarterTable = numSquares / 4;
        
        int[] corners = new int[4];
        
        corners[0] = 
        
        for (int i = 0; i < numSquares; i++) {
            
            int corner = 0;
            
            while(i != quarterTable * corner || corner == 4){
                corner++;
            }
            boolean isCorner = i == quarterTable * corner;
            
            int tempX = 0;
            int tempY = 0;
            int tempWidth = 0;
            int tempHeight = 0;
            
            if (isCorner) {
                switch(corner){
                    case 0:
                        
                        tempX = x + width - innerWidth / 2 + innerWidth;
                        tempY =  y + height - innerHeight / 2 + innerHeight;
                        tempWidth = x + width;
                        tempHeight = y + height;
                        
                    case 1:
                        
                        tempX = x;
                        tempY =  y + innerHeight + (height - innerHeight) / 2;
                        tempWidth = x + width - innerWidth / 2;
                        tempHeight = y + height;
                        
                    case 2:
                        
                        tempX = x;
                        tempY = y;
                        tempWidth = x + (width - innerWidth) / 2;
                        tempHeight = y + (height - innerHeight) / 2;
                        
                    case 3:
                        
                        tempX = x + width - innerWidth / 2 + innerWidth;
                        tempY = y;
                        tempWidth = x + width;
                        tempHeight = y + (height - innerHeight) / 2;
                        
                }
            }else{
                
                /*
                tempX = x;
                tempY =  y + innerHeight + (height - innerHeight) / 2;
                tempWidth = x + width - innerWidth / 2;
                tempHeight = y + height;
                */
            }
            
            points[i] = new Point(tempX, tempY);
            lengths[i] = new Point(tempWidth, tempHeight);
            
        }
        
        return "jaime es un manco ";
    }
    
    // GETTERS AND SETTERS //
    
    public Jugador[] getJugadores(){
        return jugadores;
    }
    
    public Casilla[] getCasillas() {
        return casillas;
    }
    
    public boolean getWin(){
        return win;
    }
}
