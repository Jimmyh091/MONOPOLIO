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
        
        GamePanel gp = new GamePanel(1024,768, false);
        KeyHandler kh = new KeyHandler(gp);
        MouseHandler mh = new MouseHandler(gp);

        gp.addKeyListener(kh);
        gp.addMouseListener(mh);
        gp.addMouseMotionListener(mh);

        gp.startGameThread();

        this.add(gp);
        
        this.pack();
        
        //this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}
