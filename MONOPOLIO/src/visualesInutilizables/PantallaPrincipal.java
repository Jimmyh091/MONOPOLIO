/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualesInutilizables;

import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author jaime
 */
public class PantallaPrincipal extends PanelBase{
    
    private BufferedImage imagenTitulo;
    private BufferedImage imagenBotonSinHover;
    private BufferedImage imagenBotonConHover;
    private BufferedImage imagenBoton;
    
    private int[] localizacionTitulo;
    private int[] parametrosBoton;
    private int anchoVentana;
    
    private JButton boton;
    
    protected PantallaPrincipal(JFrame v, AdministradorPaneles a){
        super(v, a);
        boton = new JButton();
        parametrosBoton = new int[4];
        
        parametrosBoton[0] = boton.getX();
        parametrosBoton[1] = boton.getY();
        parametrosBoton[2] = boton.getWidth();
        parametrosBoton[3] = boton.getHeight();
        
        anchoVentana = super.getAncho();
        
        try {
            imagenTitulo = ImageIO.read(getClass().getResourceAsStream("imagenes/pantallaPrincipal/titulo.png"));
            imagenBotonSinHover = ImageIO.read(getClass().getResourceAsStream("imagenes/pantallaPrincipal/boton.jpg"));
            imagenBotonConHover = ImageIO.read(getClass().getResourceAsStream("imagenes/pantallaPrincipal/botonHover.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        localizacionTitulo = new int[2];
        localizacionTitulo[0] = imagenTitulo.getWidth();
        localizacionTitulo[0] += localizacionTitulo[0] / 2;
        
        localizacionTitulo[1] = imagenTitulo.getHeight();
        localizacionTitulo[1] += localizacionTitulo[1] / 2;
        
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                imagenBoton = imagenBotonConHover;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imagenBoton = imagenBotonSinHover;
            }
        });
        
        boton.addActionListener(e -> super.pasarEscena());
        
        int anchoBotonEmpezar = 500;
        boton.setBounds((super.getAncho() / 2) - (anchoBotonEmpezar / 2), 500, anchoBotonEmpezar, 50);
        this.add(boton);
    }
    
    
    @Override
    protected void actualizar() {
        
    }
    
    @Override
    protected void dibujar(Graphics2D g2){
        super.dibujar(g2);

        g2.drawImage(imagenTitulo, (anchoVentana / 2) - (localizacionTitulo[0] / 2), 150, localizacionTitulo[0], localizacionTitulo[1], null);
        g2.drawImage(imagenBoton, parametrosBoton[0], parametrosBoton[1], parametrosBoton[2], parametrosBoton[3], null);
    }
}
