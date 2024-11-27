/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosVisuales;

import juego.VisualGameElement;

import java.awt.*;

/**
 *
 * @author EAG
 */
public class MLabel extends VisualElement{ //a ABANDONADA

    private String text;
    private Color color;
    private Font font;
    private Color background;

    public MLabel(String id, int x, int y, MObserver update, String t, int size){
        super(id, x, y, 0, 0, update);
        text = t;
        font = new Font("Arial", Font.BOLD, size);
    }

    @Override
    public void draw(Graphics2D g){
        g.setColor(color);
        g.setFont(font);
        g.drawString(text, getX(), getY());
    }

    @Override
    public void update(VisualGameElement vge){
        super.update(vge);
    }

    public String getText() {
        return text;
    }

    public Font getFont() {
        return font;
    }
}
