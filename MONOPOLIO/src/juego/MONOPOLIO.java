/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juego;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jaime y su soledad
 */
public class MONOPOLIO {

    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        /*
        Jugador[] jugadores = crearJugadores();
        Dado[] dados = crearDados();
        
        jugadores = asignarOrden(jugadores, dados);
        
        Baraja barajaComunidad = new Baraja(true);
        Baraja barajaSuerte = new Baraja(false);
        
        Casilla[] casillas = crearCasillas();
        
        Tablero tablero = new Tablero(jugadores, casillas, barajaComunidad, barajaSuerte, dados);
        
        // COSAS DE LA PARTIDA //
        
        boolean victoria = false;
        
        int numJug = jugadores.length;
        for (int i = 0; i < numJug; i++) {
            
            jugadores[i].tirar(dados, 0, 0);
            int jugadorPos = jugadores[i].getPosicion();
            
            tablero.moverJugador(jugadorPos, jugadores[i]);
            
            Casilla casilla = tablero.getCasillas()[jugadorPos];
            
            if (casilla instanceof CasillaEspecial) {
                CasillaEspecial casillaAux = (CasillaEspecial) casilla;
                
                int tipo = casillaAux.getEvento().getTipo();
                
                if (tipo == 0) casillaAux.ejecutarAccion();
                else if(tipo == 1) casillaAux.ejecutarAccion(jugadores);
                else casillaAux.ejecutarAccion(casillas);
            }else{
                
            }
        }
        
        do {
            
            
            victoria = comprobarVictoria(tablero.getJugadores());
        } while (!victoria);
        
        System.out.println("termino la partida");
*/
    }
    public static boolean comprobarVictoria(Jugador[] jugadores){
        boolean unJug = false;
        boolean dosJug = false;
        
        for (Jugador j : jugadores) {
            if (!j.getBancarrota()) {
                if (!unJug) unJug = true;
                else {
                    dosJug = true;
                    break;
                }
            }
        }
        
        return !dosJug;
    }
    
    public static Casilla[] crearCasillas(){
        String linea;
        BufferedReader leedor = null;
        int numCasillas = 0;
        Casilla[] casillas = null;
        int contador = 0;
        try {
            casillas = new Casilla[((int) Files.lines(Paths.get("src/elementos/casillas.txt")).count()) - 0];
            
            leedor = new BufferedReader(new FileReader("src/elementos/casillas.txt"));
            
            while((linea = leedor.readLine()) != null){
                String[] datos = linea.split("/");
                
                //if (datos[0].equals("1")) casillas[contador++] = new Calle(datos[1], Integer.parseInt(datos[2]), Byte.parseByte(datos[3]));
                //else casillas[contador++] = new CasillaEspecial(datos[1], Integer.parseInt(datos[2]), Byte.parseByte(datos[3]));
                
            }
        } catch (Exception ex) {
            Logger.getLogger(MONOPOLIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return casillas;
    }
    
    public static void turno(Jugador jugador, Dado[] dados){
        jugador.tirar(dados, 0, 0);
    }
    
    public static Jugador[] asignarOrden(Jugador[] jugadores, Dado[] dados){
        int numJug = jugadores.length;
        int[] orden = new int[numJug];
        
        int[] tiradas = new int[numJug];
        
        for (int i = 0; i < numJug; i++) {
            jugadores[i].tirar(dados, 0, 0);
            tiradas[i] = jugadores[i].getPosicion();
            orden[i] = i;
            jugadores[i].setPosicion(0);
        }
        
        int cont1 = 0;
        int cont2 = 0;
        
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(jugadores[i].getNombre());
        }
        
        while (cont1 < numJug) {
            cont2 = cont1++;
            
            while(cont2 != 0 && tiradas[cont2] > tiradas[cont2 - 1]){

                int basura = tiradas[cont2];
                tiradas[cont2] = tiradas[cont2 - 1];
                tiradas[cont2 - 1] = basura;

                basura = orden[cont2];
                orden[cont2] = orden[cont2 - 1];
                orden[cont2 - 1] = basura;

                cont2--;
            }
        }
        
        Jugador[] jugadoresOrdenados = new Jugador[numJug];
        
        for (int i = 0; i < numJug; i++) {
            jugadoresOrdenados[i] = jugadores[orden[i]];
        }
        
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(jugadoresOrdenados[i].getNombre());
        }
        
        return jugadoresOrdenados;
    }
    public static Jugador[] crearJugadores(){
        int numJug = 0;
        boolean jugadoresCorrectos;
        
        do {
            boolean datosCorrectos;
            do {
                datosCorrectos = true;
                System.out.println("Cuantos jugadores van a jugar?"); // no tiene mucho sentido porque supongo que hare bots pero eso ya pa el tfg
                try{
                    numJug = sc.nextByte();                
                }catch (Exception e){
                    datosCorrectos = false;
                    System.out.println("Dato incorrecto");
                }finally{
                    sc.nextLine();                
                }
                
            } while (!datosCorrectos);
            
            jugadoresCorrectos = numJug >= 2 && numJug <= 4;
            
            if (!jugadoresCorrectos) System.out.println("Tienen que haber entre 2 y 4 jugadores");
            
        } while (!jugadoresCorrectos);
        
        Jugador[] jugadores = new Jugador[numJug];
        
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = crearJugador(i);
        }
        
        return jugadores;
    }
    public static Jugador crearJugador(int i){
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
