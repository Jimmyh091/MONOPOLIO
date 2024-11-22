/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosVisuales;

import java.awt.Color;
import java.awt.Graphics2D;
import juego.Event;
import juego.Jugador;

/**
 *
 * @author EAG
 */
public class Button extends VisualElement{
    
    private int id;
    private String text;
    private boolean hover;
    private Color color;
    
    private Event event;
    
    public Button(int x, int y, int w, int h, String t, int i, Color c, Event e){
        
        super.setX(x);
        super.setY(y);
        super.setWidth(w);
        super.setHeight(h);
        
        text = t;
        id = i;
        hover = false;        
        color = c;
        event = e;
    }
    
    @Override
    public void draw(Graphics2D g){
        
    }
    
    public void activateHover(){
        hover = true;
    }
    
    public void deactiveHover(){
        hover = false;
    }
    
    protected void event(){
        event.executeEvent();
    }
    
    protected void event(Jugador j){
        event.executeEvent(j);
    }

    public Color getColor() {
        return color;
    }
}
