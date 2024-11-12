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
    
    Event asd;
    
    public prueba(int d, Event as){
        a = d;
        asd = as;
    }

    public void AAA(){
        asd.event();
    }
    
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
    
    public void asdf(){
        System.out.println("a");
    }
    
    public int suma(int... a){
        
        int suma = 0;
        
        for (int as : a) {
            suma += as;
        }
        
        return suma;
    }
}
