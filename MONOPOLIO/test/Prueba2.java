/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EAG
 */
public class Prueba2 {
    
    Prueba prueba;
    
    public Prueba2(Prueba p){
        prueba = p;
    }
    
    public void a(){
        System.out.println("a");
    }
    
    public void b(){
        prueba.a();
    }
}
