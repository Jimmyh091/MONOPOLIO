/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualesInutilizables;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jaime
 */
public abstract class PanelBase extends JPanel{
    
    private final JFrame ventana;
    private final AdministradorPaneles administradorPaneles;
    
    private final int ancho = 1366;
    private final int alto = 768;
    
    private GradientPaint gradiente;
    
    protected PanelBase(JFrame v, AdministradorPaneles a){
        ventana = v;
        administradorPaneles = a;
        
        gradiente = new GradientPaint(0, 0, new Color(100, 255, 100), 0, alto, new Color(200, 255, 200));
        
        this.setPreferredSize(new Dimension(ancho, alto));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setLayout(null);
    }

    protected abstract void actualizar();
    
    protected void dibujar(Graphics2D g2){
        g2.setPaint(gradiente);
        g2.fillRect(0, 0, ancho, alto);
    }
    
    protected void pasarEscena(){
        administradorPaneles.pasarPanel();
    }
    
    protected JFrame getVentana(){
        return ventana;
    }
    
    protected int getAncho() {
        return ancho;
    }
    protected int getAlto() {
        return alto;
    }
}
