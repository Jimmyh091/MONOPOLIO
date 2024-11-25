/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosVisuales;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author EAG
 */
public class MImage extends VisualElement implements Hoverable{
    private final BufferedImage bi;

    public MImage(String id, int x, int y, BufferedImage b){
        super.setId(id);
        super.setX(x);
        super.setY(y);
        super.setWidth(b.getWidth());
        super.setHeight(b.getHeight());

        bi = b;
    }

    public MImage(String id, int x, int y, int w, int h, BufferedImage b){
        super.setId(id);
        super.setX(x);
        super.setY(y);
        super.setWidth(w);
        super.setHeight(h);

        bi = b;
    }
    
    @Override
    public void draw(Graphics2D g){
        g.drawImage(bi, getX(), getY(), getWidth(), getHeight(), null);
    }
    
    public BufferedImage getBi() {
        return bi;
    }

    @Override
    public boolean mouseIn(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}