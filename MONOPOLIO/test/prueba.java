/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author jaime
 */
public class prueba {
    int a;
    
    
    public prueba(int d){
        a = d;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
    
    public void asfsd(prueba g){
        g.setA(3456);
    }
    
    public int suma(int... a){
        
        int suma = 0;
        
        for (int as : a) {
            suma += as;
        }
        
        return suma;
    }
}
