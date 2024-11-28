/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualesInutilizables;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author jaime
 */
public class Juego extends JFrame{
    
    
    private Juego() {
        
        setTitle("MONOPOLIO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        
        AdministradorPaneles administradorPaneles = new AdministradorPaneles();
        administradorPaneles.aniadirPanel(new PantallaPrincipal(this, administradorPaneles), "pantallaPrincipal");
        administradorPaneles.aniadirPanel(new PantallaPreparacion(this, administradorPaneles), "pantallaPreparacion");
        administradorPaneles.aniadirPanel(new PantallaJuego(this, administradorPaneles), "pantallaJuego");
        
        administradorPaneles.actualizarPanelActual();
        
        administradorPaneles.empezarHilo();
        add(administradorPaneles);
        pack();
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Juego());
    }
}
