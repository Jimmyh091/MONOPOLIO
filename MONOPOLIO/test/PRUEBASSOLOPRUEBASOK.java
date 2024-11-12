

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
        
        int[] a = new int[]{1,2};
        int[] b = new int[]{3,4};
        int[][] m = new int[][]{a, b};
        
        prueba prueba = new prueba(2, new Event() {
            @Override
            public void event() {
                System.out.println("a");
            }
        });
        
        prueba.AAA();
        
        m[0][0] = 1;
        m[0][1] = 2;
        m[1][0] = 3;
        m[1][1] = 4;
    
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(m[i][j]);
            }
        }
        
    }
}
