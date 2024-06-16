/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package monopolio;
import java.util.Scanner;
/**
 *
 * @author jaime y supolla
 */
public class MONOPOLIO {

    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Jugador[] jugadores = crearJugadores();
        Dado[] dados = crearDados();
        
        jugadores = asignarOrden(jugadores, dados);
        
        /*
            CREACION DE CARTAS Y TODA LA PEScA QUE HAY QUE VERLO PORQUE MAE MIA
        */
        
        // Tablero tablero = new Tablero(jugadores, dados);
    }
    public static void turno(Jugador jugador, Dado[] dados){
        jugador.tirar(dados);
    }
    
    public static Jugador[] asignarOrden(Jugador[] jugadores, Dado[] dados){
        byte numJug = (byte) jugadores.length;
        byte[] orden = new byte[numJug];
        
        byte[] tiradas = new byte[numJug];
        
        for (byte i = 0; i < numJug; i++) {
            tiradas[i] = jugadores[i].tirar(dados);
            orden[i] = i;
        }
        
        byte cont1 = 0;
        byte cont2 = 0;
        
        System.out.println(jugadores);
        
        while (cont1 < numJug) {
            cont2 = cont1++;
            
            while(cont2 != 0 && tiradas[cont2] > tiradas[cont2 - 1]){

                byte basura = tiradas[cont2];
                tiradas[cont2] = tiradas[cont2 - 1];
                tiradas[cont2 - 1] = basura;

                basura = orden[cont2];
                orden[cont2] = orden[cont2 - 1];
                orden[cont2 - 1] = basura;

                cont2--;
            }
        }
        
        Jugador[] jugadoresOrdenados = new Jugador[numJug];
        
        for (byte i = 0; i < numJug; i++) {
            jugadoresOrdenados[i] = jugadores[orden[i]];
        }
        
        return jugadoresOrdenados;
    }
    public static Jugador[] crearJugadores(){
        byte numJug;
        boolean jugadoresCorrectos;
        
        do {
            System.out.println("Cuantos jugadores van a jugar?"); // no tiene mucho sentido porque supongo que hare bots pero eso ya pa el tfg
            numJug = sc.nextByte();
            sc.nextLine();
            
            jugadoresCorrectos = numJug >= 2 && numJug <= 4;
            
            if (!jugadoresCorrectos) System.out.println("Tienen que haber entre 2 y 4 jugadores");
            
        } while (!jugadoresCorrectos);
        
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
    public static Dado[] crearDados(){
        Dado[] dados = new Dado[2];
        
        dados[0] = new Dado();
        dados[1] = new Dado();
        
        return dados;
    }
}
