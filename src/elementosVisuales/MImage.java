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
public class MImage extends VisualElement implements Hoverable, HoverEvent {

    private final BufferedImage bi;
    private MLabel name;
    private HoverEvent hoverEvent;

    public MImage(String id, int x, int y, int w, int h, FlatEvent updateEvent, BufferedImage b, String text, int size){
        super(id, x, y, w, h, updateEvent);
        bi = b;
        name = new MLabel("debugImageName", x + w / 2 - text.length() * (size / 4), y + h / 2 - size / 2, true, text, size);
    }

    public MImage(String id, int x, int y, FlatEvent updateEvent, BufferedImage b, String text, int size) {
        super(id, x, y, b.getWidth(), b.getHeight(), updateEvent);
        bi = b;
        name = new MLabel("debugImageName", x / 2 - text.length(), y - size / 2, true, text, size);
    }

    @Override
    public void setUpdate(MObserver update){
        super.setUpdate(update);
    }

    @Override
    public void draw(Graphics2D g){

        if (GameUtilities.DEBUG || bi == null){
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
        return pointIn(p);
    }

    @Override
    public void activateHover() {

    }

    @Override
    public void deactivateHover() {

    }

    @Override
    public boolean pointIn(Point p) {
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();

        return p.x >= x && p.x <= x + w && p.y >= y && p.y <= y + h;
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

    @Override
    public void executeHoverEvent(Point p) {

    }
}
