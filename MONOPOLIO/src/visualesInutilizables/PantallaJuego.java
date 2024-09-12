/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualesInutilizables;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import juego.Baraja;
import juego.Casilla;
import juego.Dado;
import juego.Jugador;
import juego.Tablero;

/**
 *
 * @author jaime
 */
public class PantallaJuego extends PanelBase{
    
    private JLabel turno;
    
    private BufferedImage imagenTablero;
    
    private Jugador[] jugadores;
    private Casilla[] casillas;
    private Dado[] dados;
    private Tablero tablero;
    
    protected PantallaJuego(JFrame v, AdministradorPaneles a){
        super(v, a);
    }
    
    protected void recibirDatos(Jugador[] j, Casilla[] c, Baraja b, Baraja ba, Dado[] d){
        jugadores = j;
        casillas = c;
        dados = d;
        
        tablero = new Tablero(j, c, b, ba, d);
        
        try {
            imagenTablero = ImageIO.read(getClass().getResourceAsStream("/elementos/imagenes/tablero.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(PantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void actualizar() {
        
    }
    
    @Override
    protected void dibujar(Graphics2D g){
        super.dibujar(g);
        g.drawImage(imagenTablero, 20, 20, 100, 100, null);
    }

}
