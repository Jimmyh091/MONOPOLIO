/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import visualesNuevas.GameUtilities;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Jaime
 */
public class Gameboard extends VisualGameElement{

    private int innerWidth;
    private int innerHeight;

    int numSquares;
    private Casilla[] squares;
    private HashMap<Integer, Integer> positions;

    public Gameboard(int x, int y, int w, int h, BufferedImage bi) {
        super(x, y, w, h, bi);

        numSquares = 40;
        
        asignInnerCoords();
        squares = new Casilla[numSquares];
        squares = crearCasillas();

        positions = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            positions.put(i, 0);
        }
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
        Float percentage = 0.74F;

        int innerSideLength = (int) (super.getWidth() * percentage);

        innerWidth = innerSideLength;
        innerHeight = innerSideLength;
    }
    
    public Casilla[] crearCasillas(){
        BufferedReader leedor;
        Casilla[] casillas = null;
        
        Point[][] puntos = asignPoints();

        String linea;

        try {
            List lineas = Files.readAllLines(Paths.get("resources/contenido/casillas.txt"));
            int linesCounter = (int) lineas.stream()
                    .filter(a -> ((String)a).charAt(0) != '#')
                    .count();

            casillas = new Casilla[linesCounter];
            leedor = new BufferedReader(new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("contenido/casillas.txt"))));

            int contador = 0;
            while((linea = leedor.readLine()) != null){
                if (linea.charAt(0) != '#') {
                    String[] datos = linea.split("/");
                    
                    int x = puntos[0][contador].x;
                    int y = puntos[0][contador].y;
                    int width = puntos[1][contador].x;
                    int height = puntos[1][contador].y;

                    int type = Integer.parseInt(datos[0]);
                    String name = datos[1];
                    int value = Integer.parseInt(datos[2]);
                    int group = Integer.parseInt(datos[3]);

                    if (type == 1) {
                        casillas[contador] = new Calle(x, y, width, height, null, name, value, group);
                    } else {
                        casillas[contador] = new CasillaEspecial(x, y, width, height, null, name, value, null); //t implementar evento
                    }

                    contador++;
                }
            }
        } catch (Exception ex) {
            System.out.println("LOG: ERROR.Creacion casillas");
        }
        
        return casillas;
    }
    
    public Point[][] asignPoints(){
        Point[] points = new Point[numSquares];
        Point[] lengths = new Point[numSquares];
        
        // Just a quarter of the total squares in the table
        int quarterTable = numSquares / 4;
                
        for (int i = 0; i < numSquares; i++) {

            int numCorner = 1;

            while(i >= (quarterTable * numCorner) && numCorner < 4){
                numCorner++;
            }
            boolean isCorner = i == quarterTable * (numCorner - 1);
            
            int tempX = super.getX();
            int tempY = super.getY();
            int tempWidth = 0;
            int tempHeight = 0;
            
            if (isCorner) {
                switch(numCorner){
                    case 1:
                        
                        tempX += (super.getWidth() - innerWidth) / 2 + innerWidth;
                        tempY += (super.getHeight() - innerHeight) / 2 + innerHeight;
                        break;

                    case 2:

                        tempX = super.getX();
                        tempY += innerHeight + (super.getHeight() - innerHeight) / 2;
                        break;
                        
                    case 3:
                        
                        tempX = super.getX();
                        tempY = super.getY();
                        break;
                        
                    case 4:
                        
                        tempX += (super.getWidth() - innerWidth) / 2 + innerWidth;
                        tempY = super.getY();
                        break;
                        
                    default:
                        System.out.println("LOG: ERROR.Asignacion Coordenadas Esquinas");
                }
                
                tempWidth = (super.getWidth() - innerWidth) / 2;
                tempHeight = (super.getHeight() - innerHeight) / 2;
                
            }else{
                switch(numCorner){
                    case 1:

                        tempX += (innerWidth + (super.getWidth() - innerWidth) / 2) - (innerWidth / 9 * i);
                        tempY += innerHeight + (super.getHeight() - innerHeight) / 2;
                        tempWidth += innerWidth / 9;
                        tempHeight += (super.getHeight() - innerHeight) / 2;
                        break;
                        
                    case 2:

                        tempX = super.getX();
                        tempY += (innerHeight + (super.getHeight() - innerHeight) / 2) - (innerHeight / 9 * (i - quarterTable * (numCorner - 1)));
                        tempWidth += (super.getWidth() - innerWidth) / 2;
                        tempHeight += innerHeight / 9;
                        break;
                        
                    case 3:

                        tempX += ((super.getWidth() - innerWidth) / 2) + (innerWidth / 9 * (i - (quarterTable * (numCorner - 1)) - 1));
                        tempY = super.getY();
                        tempWidth += innerWidth / 9;
                        tempHeight += (super.getHeight() - innerHeight) / 2;
                        break;
                        
                    case 4:
                        
                        tempX += innerWidth + (super.getWidth() - innerWidth) / 2;
                        tempY += ((super.getHeight() - innerHeight) / 2) + (innerHeight / 9 * (i - (quarterTable * (numCorner - 1)) - 1));
                        tempWidth += (super.getWidth() - innerWidth) / 2;
                        tempHeight += innerHeight / 9;
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
