/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosVisuales;

import java.awt.Graphics2D;

/**
 *
 * @author EAG
 */
public class Label extends VisualElement{
    private String text;
    
    public Label(int x, int y, int w, int h, String t){
        super.setX(x);
        super.setY(y);
        super.setWidth(w);
        super.setHeight(h);
        
        text = t;
    }

    @Override
    public void draw(Graphics2D g){
        
    }
    
    public String getText() {
        return text;
    }
}
