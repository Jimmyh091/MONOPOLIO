/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualesInutilizables;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author jaime
 */
public class AdministradorPaneles extends JPanel implements Runnable{

    private CardLayout cardLayout;
    private Thread mainThread;
    
    private final int fps = 60;
    private PantallaPrincipal pP;
    private PantallaPreparacion pPr;
    private PantallaJuego pJ;
    
    private int contadorPaneles;
    private String panelActual;
    private ArrayList<String> nombrePaneles;
    
    protected AdministradorPaneles(){
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        
        this.setDoubleBuffered(true);
        
        contadorPaneles = 0;
        nombrePaneles = new ArrayList<String>();
        
    }
    
    @Override
    public void run() {
        
        double intervaloDibujo = 1000000000 / fps;
        double delta = 0;
        long vezAnterior = System.nanoTime();
        long vezActual;
        
        long cronometro = 0;
        int refrescosPantalla = 0;
        
        while(mainThread != null){
            
            vezActual = System.nanoTime();
            delta += (vezActual - vezAnterior) / intervaloDibujo;
            cronometro += vezActual - vezAnterior;
            vezAnterior = vezActual;
            
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                refrescosPantalla++;                
            }
            
            if (cronometro >= 1000000000) {
                System.out.println("FPS: " + refrescosPantalla);
                refrescosPantalla = 0;
                cronometro = 0;
            }
            
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(AdministradorPaneles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    protected void empezarHilo(){
        SwingUtilities.invokeLater(() -> {
            mainThread = new Thread(this);
            mainThread.start();
        });
    }
    
    private void update(){
        
        switch (panelActual) {
            case "pantallaPrincipal" -> pP.actualizar();
            case "pantallaPreparacion" -> pPr.actualizar();
            case "pantallaJuego" -> pJ.actualizar();
            default -> {}
        }
        
    }
    
    
    @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        switch (panelActual) {
            case "pantallaPrincipal" -> pP.dibujar(g2);
            case "pantallaPreparacion" -> pPr.dibujar(g2);
            case "pantallaJuego" -> pJ.dibujar(g2);
            default -> {}
        }
        
        g2.dispose();

    }

    
    protected void aniadirPanel(JPanel panel, String nombrePanel){
        this.add(panel, nombrePanel);
        nombrePaneles.add(nombrePanel);
        
        /*
        if (panel instanceof PantallaPrincipal pantallaPrincipal) pP = pantallaPrincipal;
        else if (panel instanceof PantallaPreparacion pantallaPreparacion) pPr = pantallaPreparacion;
        else if (panel instanceof PantallaJuego pantallaJuego) pJ = pantallaJuego;
*/
    }
    
    protected void pasarPanel(){
        cardLayout.next(this);
        contadorPaneles++;
        actualizarPanelActual();
    }
    protected void mostrarPanel(String panel){
        cardLayout.show(this, panel);
        contadorPaneles = nombrePaneles.indexOf(panel);
        actualizarPanelActual(panel);
    }
    
    private void actualizarPanelActual(String panel){
        panelActual = panel;
    }
    protected void actualizarPanelActual(){
        panelActual = nombrePaneles.get(contadorPaneles);
    }
}
