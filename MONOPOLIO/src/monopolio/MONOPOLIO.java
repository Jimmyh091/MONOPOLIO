/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package monopolio;
import java.util.Scanner;
/**
 *
 * @author jaime
 */
public class MONOPOLIO {

    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    public static Jugador[] crearJugadores(){
        System.out.println("Cuantos jugadores van a jugar?");
        byte numJug = sc.nextByte();
        
        Jugador[] jugadores = new Jugador[numJug];
        
        for (byte i = 0; i < jugadores.length; i++) {
            jugadores[i] = crearJugador(i);
        }
        
        return jugadores;
    }
    public static Jugador crearJugador(byte i){
        System.out.println("Que nombre tiene tu jugador?");
        String nombre = sc.nextLine();
        
        return new Jugador(i, nombre);
    }
}
