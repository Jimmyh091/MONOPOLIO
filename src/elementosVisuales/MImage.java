/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosVisuales;

import juego.MObservable;
import juego.VisualGameElement;
import visualesNuevas.GameUtilities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jaime
 */
public class MImage extends VisualElement implements Hoverable {

    private final BufferedImage bi;
    private MLabel name;

    public MImage(String id, int x, int y, int w, int h, BufferedImage b, String text, int size){
        super(id, x, y, w, h, null);
        bi = b;
        name = new MLabel("debugImageName", x + w / 2 - text.length() * (size / 4), y + h / 2 - size / 2, text, size, null);
    }

    public MImage(String id, int x, int y, BufferedImage b, String text, int size) {
        super(id, x, y, b.getWidth(), b.getHeight(), null);
        bi = b;
        name = new MLabel("debugImageName", x / 2 - text.length(), y - size / 2, text, size, null);
    }

    @Override
    public void setUpdate(MObserver update){
        super.setUpdate(update);
    }

    @Override
    public void draw(Graphics2D g){

        if (GameUtilities.DEBUG || bi != null){
            g.drawRect(getX(), getY(), getWidth(), getHeight());
            name.draw(g);
        }else{
            g.drawImage(bi, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
    
    public BufferedImage getBi() {
        return bi;
    }

    @Override
    public boolean mouseIn(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(MObservable mo) { //? es igual en todos, no creo que sea asi
        super.update(mo);
    }

    public String getName() {
        return name.getText();
    }
    public void setName(String name) {
        this.name.setText(name);
    }
}
