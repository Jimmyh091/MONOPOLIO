/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosVisuales;

import juego.VisualGameElement;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jaime
 */
public class MImage extends VisualElement implements Hoverable {
    private final BufferedImage bi;
    private String name;

    public MImage(String id, int x, int y, BufferedImage b, String name) {
        super(id, x, y, b.getWidth(), b.getHeight(), null);
        bi = b;
        this.name = name;
    }

    public MImage(String id, int x, int y, int w, int h, BufferedImage b){
        super(id, x, y, w, h, null);
        bi = b;
    }

    public void setUpdate(MObserver update){
        super.setUpdate(update);
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

    @Override
    public void update(VisualGameElement vge) { //? es igual en todos, no creo que sea asi
        super.update(vge);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
