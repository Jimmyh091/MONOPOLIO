/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosVisuales;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import juego.GameEvent;
import juego.Jugador;

/**
 *
 * @author EAG
 */
public class Button extends VisualElement implements Clickable, Hoverable{

    private Label text;
    private boolean hover;
    private Color color;
    private Color hoverColor;
    private Event event;
    
    public Button(int x, int y, int w, int h, String t, String i, Color c, Event e){
        
        super.setX(x);
        super.setY(y);
        super.setWidth(w);
        super.setHeight(h);
        
        text = new Label(x, y, w, h, t); //t deberia estar en el centro
        super.setId(i);
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
    public boolean clickIn(Point p) {
        return pointIn(p);
    }
    
    @Override
    public boolean mouseIn(Point p) {
        return pointIn(p);
    }

    private boolean pointIn(Point p){
        int x = getX();
        int y = getY();

        return p.x >= x && p.x <= x && p.y >= y && p.y <= y;
    }

    public void executeEvent(){
        event.executeEvent();
    }
    public void activateHover(){hover = true;}
    public void deactivateHover(){hover = false;}

    public Color getColor() {
        return (hover) ? hoverColor : color;
    }

}