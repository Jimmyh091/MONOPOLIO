/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopolio;

/**
 *
 * @author jaime
 */
public class Carta {
    private byte id;
    private Byte propietario;
    private String titulo;
    private String desc;
    private Evento evento;
    
    public Carta(byte i, String t, String d, Evento e){
        id = i;
        propietario = null;
        titulo = t;
        desc = d;
        evento = e;
    }
    public Carta(byte i, byte p, String t, String d, Evento e){
        id = i;
        propietario = p;
        titulo = t;
        desc = d;
        evento = e;
    }
    
}
