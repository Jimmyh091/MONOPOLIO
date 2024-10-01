

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author jaime
 */
public class PRUEBASSOLOPRUEBASOK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        prueba p = new prueba(3){
            
            @Override
            public void asdf(){
                System.out.println("hola");
            }
        };
        
        for (int i = 0; i < 10; i++) {
            
        }
        
        p.asdf();
        
        
        int a = p.suma(3,4,5,6,7,6,5,32,5,8,9,7,56);
        System.out.println(a);
    }
}
