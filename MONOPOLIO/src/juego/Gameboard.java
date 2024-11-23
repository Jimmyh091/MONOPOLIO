/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author EAG
 */
public class Gameboard {
    
    private int x;
    private int y;
    private int width;
    private int height;
        
    private int innerX;
    private int innerY;
    private int innerWidth;
    private int innerHeight;
    
    private Casilla[] squares;
        
    public Gameboard(int x, int y, int w, int h){
        
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }
    
    public void movePlayer(int advanceSquares, Jugador player){
        if (advanceSquares == -1) { // -1 = jail            
            jumpTo(18/*jail square*/, player);
        }else{
            moveTo(player.getPosicion() + advanceSquares, player);
        }        
    }
    
    public void moveTo(int position, Jugador player){
        squares[position].setJugador(player);
        squares[position].interact(player);
    }
    
    public void jumpTo(int position, Jugador player){
        squares[position].setJugador(player);
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
    
    public Casilla[] crearCasillas(){
        BufferedReader leedor;
        Casilla[] casillas = null;
        
        Point[][] puntos = asignPoints();

        String linea;
        try {
            casillas = new Casilla[((int) Files.lines(Paths.get("/elementos/contenido/casillas.txt")).count()) - 0];
            
            leedor = new BufferedReader(new FileReader("/elementos/contenido/casillas.txt"));
            
            int contador = 0;
            while((linea = leedor.readLine()) != null){
                if (linea.charAt(0) != '#') {
                    String[] datos = linea.split("/");
                    
                    int tempX = puntos[0][contador].x;
                    int tempY = puntos[0][contador].y;
                    int tempWidth = puntos[1][contador].x;
                    int tempHeight = puntos[1][contador].y;
                                        
                    if (datos[0].equals("1")) casillas[contador++] = new Calle(tempX, tempY, tempWidth, tempHeight, datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]));
                    else casillas[contador++] = new CasillaEspecial(tempX, tempY, tempWidth, tempHeight, datos[1], Integer.parseInt(datos[2]), null);
                }
            }
        } catch (Exception ex) {
            System.out.println("hola");
        }
        
        return casillas;
    }
    
    private Point[][] asignPoints(){
        Point[] points = new Point[squares.length];
        Point[] lengths = new Point[squares.length];
        
        // Just a quarter of the total squares in the table
        int quarterTable = squares.length / 4;
                
        for (int i = 0; i < squares.length; i++) {
            
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
}
