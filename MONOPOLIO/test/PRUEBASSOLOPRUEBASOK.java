
import visualesNuevas.MouseHandler;





/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author jaime
 */
public class PRUEBASSOLOPRUEBASOK {

    public MouseHandler mh;
    public PRUEBASSOLOPRUEBASOK(){
        mh = new MouseHandler();
    }
    public static void main(String[] args) {
        
        PRUEBASSOLOPRUEBASOK a = new PRUEBASSOLOPRUEBASOK();
        System.out.println("s");
        while(true){
            if (a.mh.mouseMoved) {
                System.out.println(a.mh.mousePosition);
            }
        }
        
    }
}
