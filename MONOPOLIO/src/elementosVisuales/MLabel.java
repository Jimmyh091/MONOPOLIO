/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosVisuales;

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

    public MLabel(String id, int x, int y, String t){
        super.setId(id);
        super.setX(x);
        super.setY(y);
        
        text = t;

        font = new Font("Arial", Font.BOLD, 24);
    }

    @Override
    public void draw(Graphics2D g){
        g.setColor(color);
        g.setFont(font);
        g.drawString(text, getX(), getY());

    }
    
    public String getText() {
        return text;
    }
}
