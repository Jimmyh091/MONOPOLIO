/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopolio;

/**
 *
 * @author jaime
 */
public class CasillaEspecial {
    private byte id;
    private Evento evento;
    
    public CasillaEspecial(byte i, byte id){
        id = i;
        evento = new Evento(id);
    }
}
