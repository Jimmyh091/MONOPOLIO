
import javax.swing.JFrame;
import visualesNuevas.MouseHandler;





/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author jaime
 */
public class PRUEBASSOLOPRUEBASOK extends JFrame{

    public MouseHandler mh;
    public PRUEBASSOLOPRUEBASOK(){
        
        this.setBounds(100,100,500,500);
        this.setVisible(true);
        mh = new MouseHandler();
        this.addMouseListener(mh);
    }
    public static void main(String[] args) {
        
        PRUEBASSOLOPRUEBASOK a = new PRUEBASSOLOPRUEBASOK();
        
        while(true){
            if (a.mh.mouseMoved) {
                System.out.println(a.mh.mousePosition);
            }
        }
        
    }
}
