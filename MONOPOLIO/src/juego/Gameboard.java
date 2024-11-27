/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import visualesNuevas.GameUtilities;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 *
 * @author EAG
 */
public class Gameboard extends VisualGameElement{

    private int innerX;
    private int innerY;
    private int innerWidth;
    private int innerHeight;
    
    private Casilla[] squares;
    private HashMap<Integer, Integer> positions;

    public Gameboard(int x, int y, int w, int h, BufferedImage bi){
        super(x, y, w, h, bi);

        asignInnerCoords();
        squares = new Casilla[48];
        squares = crearCasillas();

        positions = new HashMap<>();
        positions.put(0, 0);
        positions.put(1, 0);
        positions.put(2, 0);
        positions.put(3, 0);


    }
    
    public void movePlayer(int advanceSquares, Jugador player){
        if (advanceSquares == -1) { // -1 = jail            
            jumpTo(31 /*jail square*/, player);
        }else{
            moveTo(positions.get(player.getId()) + advanceSquares, player);
        }

        if (GameUtilities.DEBUG) System.out.println("Jugador " + player.getNombre() + " movido a la casilla " + positions.get(player.getId()) + advanceSquares);

    }
    
    public void moveTo(int position, Jugador player){
        squares[position].setJugador(player);
        squares[position].interact(player);

        if (GameUtilities.DEBUG) System.out.println("Jugador " + player.getNombre() + " movido a la casilla " + position);

    }
    
    public void jumpTo(int position, Jugador player){
        squares[position].setJugador(player);

        if (GameUtilities.DEBUG) System.out.println("Jugador " + player.getNombre() + " saltado a la casilla " + position);

    }

    private void asignInnerCoords(){
        Float percentage = 0.8F;

        int innerSideLength = (int) (super.getWidth() * percentage);

        int margin = (super.getWidth() - innerSideLength) / 2;

        innerX = super.getX() + margin;
        innerY = getY() + margin;
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
                    
                    int x = puntos[0][contador].x;
                    int y = puntos[0][contador].y;
                    int width = puntos[1][contador].x;
                    int height = puntos[1][contador].y;
                                        
                    if (datos[0].equals("1")) casillas[contador++] = new Calle(x, y, width, height, null, datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]));
                    else casillas[contador++] = new CasillaEspecial(x, y, width, height, null/*imagen*/, datos[1], Integer.parseInt(datos[2]), null);
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
                        
                        tempX = super.getX() + super.getWidth() - innerWidth / 2 + innerWidth;
                        tempY =  super.getY() + super.getHeight() - innerHeight / 2 + innerHeight;
                        break;
                        
                    case 1:
                        
                        tempX = super.getX();
                        tempY =  super.getY() + innerHeight + (super.getHeight() - innerHeight) / 2;
                        break;
                        
                    case 2:
                        
                        tempX = super.getX();
                        tempY = super.getY();
                        break;
                        
                    case 3:
                        
                        tempX = super.getX() + super.getWidth() - innerWidth / 2 + innerWidth;
                        tempY = super.getY();
                        break;
                        
                    default:
                        System.out.println("LOG: ERROR.Asignacion Coordenadas Esquinas");
                }
                
                tempWidth = (super.getWidth() - innerWidth) / 2;
                tempHeight = (super.getHeight() - innerHeight) / 2;
                
            }else{
                switch(numCorner){
                    case 0:
                        
                        tempX = super.getX() + (innerWidth + (super.getWidth() - innerWidth) / 2) - (innerWidth / 9 * (i + 1));
                        tempY = 0;
                        tempWidth = innerWidth / 9;
                        tempHeight = innerHeight + (super.getHeight() - innerHeight) / 2;
                        break;
                        
                    case 1:
                        
                        tempX = 0;
                        tempY = 0;
                        tempWidth = (super.getWidth() - innerWidth) / 2;
                        tempHeight = innerHeight / 9;
                        break;
                        
                    case 2:
                        
                        tempX = 0;
                        tempY = 0;
                        tempWidth = innerWidth / 9;
                        tempHeight = innerHeight + (super.getHeight() - innerHeight) / 2;
                        break;
                        
                    case 3:
                        
                        tempX = 0;
                        tempY = 0;
                        tempWidth = (super.getWidth() - innerWidth) / 2;
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

    public HashMap<Integer, Integer> getPositions() {
        return positions;
    }
    public void setPositions(HashMap<Integer, Integer> positions) {
        this.positions = positions;
    }

    public Casilla[] getSquares() {
        return squares;
    }
}
