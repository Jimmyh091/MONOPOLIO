/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualesNuevas;

import javax.swing.JFrame;

/**
 *
 * @author jaime
 */
public class Ventana extends JFrame{
    public Ventana(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setTitle("MONOPOLIO");
        
        GamePanel gp = new GamePanel(500,500);
        
        this.add(gp);
        
        this.pack();
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}
