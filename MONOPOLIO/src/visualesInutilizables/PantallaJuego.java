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
import juego.Jugador;
import juego.CuboDados;

/**
 *
 * @author jaime
 */
public class PantallaJuego extends PanelBase{
    
    private JLabel turno;
    
    private BufferedImage imagenTablero;
    
    private Jugador[] jugadores;
    private Casilla[] casillas;
    
    protected PantallaJuego(JFrame v, AdministradorPaneles a){
        super(v, a);
    }
    
    protected void recibirDatos(Jugador[] j, Casilla[] c, Baraja b, Baraja ba, CuboDados d){
        jugadores = j;
        casillas = c;
        
        
        try {
            imagenTablero = ImageIO.read(getClass().getResourceAsStream("/imagenes/tablero.jpg"));
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
