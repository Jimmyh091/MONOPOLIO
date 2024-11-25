/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualesInutilizables;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jaime
 */
public class PantallaPreparacion extends PanelBase{
    
    private BufferedImage podio;
    private BufferedImage botonDerechaImagen;
    private BufferedImage botonIzquierdaImagen;
    private BufferedImage botonContinuarSinHover;
    private BufferedImage botonContinuarConHover;
    private final BufferedImage[] fichas;
    private final int[] fichasPanel;
    private JPanel[] panelesBoton;
    
    private final int anchoFinal = 130;
    private final int alto = 450;
    private int anchoPanel;
    private int altoPanel;
    private final int separado = 50;
    private final int anchoPodio;
    private int fichaMostrar;
    private int panelMostrar;
    private int[] puntoBotIzq;
    private int[] puntoBotDer;
    private boolean botonesVisibles;
    
    protected PantallaPreparacion(JFrame v, AdministradorPaneles a){
        
        super(v, a);

        fichaMostrar = 0;
        
        fichas = new BufferedImage[7];
        fichasPanel = new int[4];
        panelesBoton = new JPanel[4];
        
        try {
            podio = ImageIO.read(getClass().getResourceAsStream("imagenes/pantallaPreparacion/podio.jpg"));
            botonIzquierdaImagen = ImageIO.read(getClass().getResourceAsStream("imagenes/pantallaPreparacion/flechaIzquierda.jpg"));
            botonDerechaImagen = ImageIO.read(getClass().getResourceAsStream("imagenes/pantallaPreparacion/flechaIzquierda.jpg"));
            botonContinuarSinHover = ImageIO.read(getClass().getResourceAsStream("imagenes/pantallaPreparacion/botonContinuarSinHover.jpg"));
            botonContinuarConHover = ImageIO.read(getClass().getResourceAsStream("imagenes/pantallaPreparacion/botonContinuarConHover.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(PantallaPreparacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        anchoPodio = podio.getWidth() / 8;
        
            // ARREGLAR ABAJO
            //fichas = cogerFichas("elementos/pantallaPreparacion/fichas");
        try {
            fichas[0] = ImageIO.read(getClass().getResourceAsStream("imagenes/pantallaPreparacion/fichas/barco.png"));
            fichas[1] = ImageIO.read(getClass().getResourceAsStream("imagenes/pantallaPreparacion/fichas/bota.png"));
            fichas[2] = ImageIO.read(getClass().getResourceAsStream("imagenes/pantallaPreparacion/fichas/coche.png"));
            fichas[3] = ImageIO.read(getClass().getResourceAsStream("imagenes/pantallaPreparacion/fichas/dedal.png"));
            fichas[4] = ImageIO.read(getClass().getResourceAsStream("imagenes/pantallaPreparacion/fichas/perro.png"));
            fichas[5] = ImageIO.read(getClass().getResourceAsStream("imagenes/pantallaPreparacion/fichas/plancha.png"));
            fichas[6] = ImageIO.read(getClass().getResourceAsStream("imagenes/pantallaPreparacion/fichas/sombrero.png"));
        } catch (IOException ex) {
            Logger.getLogger(PantallaPreparacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelesBoton = crearPanelesBoton();
        
        for (int i = 0; i < 4; i++) {
            this.add(panelesBoton[i]);
        }        
    }
    
    @Override
    protected void actualizar() {
        anchoPanel = panelesBoton[panelMostrar].getX();
    }
    
    @Override
    protected void dibujar(Graphics2D g2){
        
        super.dibujar(g2);
        
        for (int i = 0; i < 4; i++) {
            
            // podio
            int ancho = anchoFinal + anchoPodio * i + separado * i;
            g2.drawImage(podio, ancho, alto, podio.getWidth() / 8, podio.getHeight() / 8, null);
            
            JPanel panel = panelesBoton[panelMostrar];
            
            // borde paneles
            //g2.drawRect(panel.getX(), panel.getY(), panel.getWidth(), panel.getHeight());
            g2.setColor(Color.red);
            

            // fichas
            //g2.drawImage(fichas[fichasPanel[i]], ancho, alto - 250, fichas[i].getWidth(), fichas[i].getHeight(), null);
            g2.drawImage(fichas[fichasPanel[i]], panelesBoton[i].getX(), panel.getY(), panel.getWidth(), panel.getHeight(), panel);
            g2.drawRect(panel.getX(), panel.getY(), panel.getWidth(), panel.getHeight());
        }
        
        // botones
        if (botonesVisibles) {
            g2.drawRect(anchoPanel + puntoBotIzq[0], altoPanel + puntoBotIzq[1], puntoBotIzq[2], puntoBotIzq[3]);
            g2.setColor(Color.red);
            g2.drawRect(anchoPanel + puntoBotDer[0], altoPanel + puntoBotDer[1], puntoBotDer[2], puntoBotDer[3]);
            g2.setColor(Color.red);
            g2.drawImage(botonIzquierdaImagen, anchoPanel + puntoBotIzq[0], altoPanel + puntoBotIzq[1], puntoBotIzq[2], puntoBotIzq[3], null);
            g2.drawImage(botonDerechaImagen, anchoPanel + puntoBotDer[0], altoPanel + puntoBotDer[1], puntoBotDer[2], puntoBotDer[3], null);                
        }
    }
    
    // ARREGLAR
    
    private BufferedImage[] cogerFichas(String path){
        ArrayList<BufferedImage> imagenes = new ArrayList<>();
        Enumeration<URL> URLImagenes = null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        
        try {
            URLImagenes = classLoader.getResources(path); // no va bien, solo coge la primera imagen
        } catch (IOException ex) {
            Logger.getLogger(PantallaPreparacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int contador = 0;
        while(URLImagenes.hasMoreElements()){
            URL url = URLImagenes.nextElement();
            File directorio = null;

            try {
                directorio = new File(url.toURI());
            } catch (URISyntaxException ex) {
                Logger.getLogger(PantallaPreparacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            File[] imagenesDir = directorio.listFiles();
            
            try {
                InputStream link = new FileInputStream(imagenesDir[contador++]);
                imagenes.add(ImageIO.read(link));
            } catch (IOException ex) {
                Logger.getLogger(PantallaPreparacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return imagenes.toArray(new BufferedImage[7]);
    }

    private JPanel[] crearPanelesBoton(){
        JPanel[] paneles = new JPanel[4];
        
        for (int i = 0; i < 4; i++) {
            
            int ancho = anchoFinal + anchoPodio * i + separado * i;
            int anchoBoton = 50;
            int anchoPanel = ancho - anchoBoton;
            altoPanel = alto - 200;
            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setBounds(ancho, alto - 200, anchoFinal + 50 + anchoBoton * 2, podio.getHeight() / 8);
            // ARREGLAR
            
            int altoBoton = 50;
            int fichasLength = fichas.length;
            
            panel.add(new JLabel("" + i));
            
            JButton botonIzquierda = new JButton();
            botonIzquierda.setBounds(0, panel.getY() / 2 - altoBoton / 2, anchoBoton, altoBoton);
            botonIzquierda.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    botonesVisibles = true;
                }
                
                @Override
                public void mouseClicked(MouseEvent e){
                    JLabel label = (JLabel) panel.getComponent(0);
                    
                    if (fichaMostrar == 0) fichaMostrar = fichasLength - 1;
                    else fichaMostrar--;
                    
                    int num = Integer.parseInt(label.getText());
                    fichasPanel[num] = fichaMostrar;
                }
            });
            panel.add(botonIzquierda);
            
            JButton botonDerecha = new JButton();
            botonDerecha.setBounds(panel.getWidth() - anchoBoton, (alto - 200) / 2 - altoBoton / 2, anchoBoton, altoBoton);
            botonDerecha.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    botonesVisibles = true;
                }
                
                @Override
                public void mouseClicked(MouseEvent e){
                    JLabel label = (JLabel) panel.getComponent(0);
                    
                    if (fichaMostrar == fichasLength - 1) fichaMostrar = 0;
                    else fichaMostrar++;
                    
                    int num = Integer.parseInt(label.getText());
                    fichasPanel[num] = fichaMostrar;
                }
            });
            panel.add(botonDerecha);
            
            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    
                    JLabel label = (JLabel) panel.getComponent(0);
                    panelMostrar = Integer.parseInt(label.getText());
                    
                    puntoBotIzq = new int[]{(int) botonIzquierda.getX(), (int) botonIzquierda.getY(), botonIzquierda.getWidth(), botonIzquierda.getHeight()};
                    puntoBotDer = new int[]{(int) botonDerecha.getX(), (int) botonDerecha.getY(), botonDerecha.getWidth(), botonDerecha.getHeight()};
                    
                    botonesVisibles = true;
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    botonesVisibles = false;
                }
            });
            
            
            paneles[i] = panel;
        }
        
        return paneles;
    }
}
