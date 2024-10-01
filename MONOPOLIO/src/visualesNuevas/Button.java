/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualesNuevas;

import java.awt.Color;
import juego.Tablero;

/**
 *
 * @author EAG
 */
public class Button {
    
    private MouseHandler mh; // ???
    
    private int x;
    private int y;
    private int width;
    private int height;
    private String text;
    private int id;
    private boolean hoverActive;
    private Color color;
    
    public Button(int x, int y, int w, int h, String t, int i, Color c){
        mh = new MouseHandler();
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        text = t;
        id = i;
        hoverActive = false;
        color = c;
    }
    
    protected void triggerHover(){
        hoverActive = !hoverActive;
    }
    
    protected void event(){
        // se declara cuando inicialice el objeto
    }
}
