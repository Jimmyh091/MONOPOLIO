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
    
    public Casilla[] crearCasillas(){
        BufferedReader leedor;
        Casilla[] casillas = null;
        
        Point[][] puntos = asignPoints();

        String linea;
        try {
            casillas = new Casilla[((int) Files.lines(Paths.get("src/elementos/contenido/casillas.txt")).count()) - 0];
            
            leedor = new BufferedReader(new FileReader("src/elementos/contenido/casillas.txt"));
            
            int contador = 0;
            while((linea = leedor.readLine()) != null){
                if (linea.charAt(0) != '#') {
                    String[] datos = linea.split("/");
                    
                    int tempX = puntos[0][contador].x;
                    int tempY = puntos[0][contador].y;
                    int tempWidth = puntos[1][contador].x;
                    int tempHeight = puntos[1][contador].y;
                                        
                    if (datos[0].equals("1")) casillas[contador++] = new Calle(tempX, tempY, tempWidth, tempHeight, datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]));
                    else casillas[contador++] = new CasillaEspecial(tempX, tempY, tempWidth, tempHeight, datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]));
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
    
    private void asignInnerCoords(){
        int percentage = 75;
        
        int innerSideLength = width * (percentage / 100);
        
        int margin = (width - innerSideLength) / 2;
        
        innerX = x + margin;
        innerY = y + margin;
        innerWidth = innerSideLength;
        innerHeight = innerSideLength;
    }    
    private Point[][] asignPoints(){
        Point[] points = new Point[numSquares];
        Point[] lengths = new Point[numSquares];
        
        // Just a quarter of the total squares in the table
        int quarterTable = numSquares / 4;
                
        for (int i = 0; i < numSquares; i++) {
            
            int numCorner = 0;
            int corner = 0;
            
            while(i > (quarterTable * numCorner) && numCorner < 4){
                numCorner++;
            }
            while(i != quarterTable * corner && corner != 4){
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
                        break;
                        
                    case 1:
                        
                        tempX = x;
                        tempY =  y + innerHeight + (height - innerHeight) / 2;
                        break;
                        
                    case 2:
                        
                        tempX = x;
                        tempY = y;
                        break;
                        
                    case 3:
                        
                        tempX = x + width - innerWidth / 2 + innerWidth;
                        tempY = y;
                        break;
                        
                    default:
                        System.out.println("LOG: ERROR.Asignacion Coordenadas Esquinas");
                }
                
                tempWidth = (width - innerWidth) / 2;
                tempHeight = (height - innerHeight) / 2;
                
            }else{
                switch(numCorner){
                    case 0:
                        
                        tempX = x + (innerWidth + (width - innerWidth) / 2) - (innerWidth / 9 * (i + 1));
                        tempY = 0;
                        tempWidth = innerWidth / 9;
                        tempHeight = innerHeight + (height - innerHeight) / 2;
                        break;
                        
                    case 1:
                        
                        tempX = 0;
                        tempY = 0;
                        tempWidth = (width - innerWidth) / 2;
                        tempHeight = innerHeight / 9;
                        break;
                        
                    case 2:
                        
                        tempX = 0;
                        tempY = 0;
                        tempWidth = innerWidth / 9;
                        tempHeight = innerHeight + (height - innerHeight) / 2;
                        break;
                        
                    case 3:
                        
                        tempX = 0;
                        tempY = 0;
                        tempWidth = (width - innerWidth) / 2;
                        tempHeight = innerHeight / 9;
                        break;
                        
                    default:
                        System.out.println("LOG: ERROR.Asignacion Coordenadas Casillas");
                }
            }
            
            points[i] = new Point(tempX, tempY);
            lengths[i] = new Point(tempWidth, tempHeight);
            
        }
        
        return new Point[][]{points, lengths};
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
