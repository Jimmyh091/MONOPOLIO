/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosVisuales;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import juego.Event;
import juego.Jugador;

/**
 *
 * @author EAG
 */
public class Button extends VisualElement implements Clickable{
    
    private int id;
    private Label text;
    private boolean hover;
    private Color color;
    
    private Event event;
    
    public Button(int x, int y, int w, int h, String t, int i, Color c, Event e){
        
        super.setX(x);
        super.setY(y);
        super.setWidth(w);
        super.setHeight(h);
        
        text = new Label(x, y, w, h, t); //t deberia estar en el centro
        id = i;
        hover = false;        
        color = c;
        event = e;
    }
    
    @Override
    public void draw(Graphics2D g){
        g.setColor(color);
        g.drawRect(getX(), getY(), getWidth(), getHeight());
        
        text.draw(g);
    }

    @Override
    public Event clicked(Point p) {
        
        int x = getX();
        int y = getY();
        
        if (p.x >= x && p.x <= x && p.y >= y && p.y <= y) {
            return event;
        }else{
            return null;            
        }
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
