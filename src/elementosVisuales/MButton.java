/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosVisuales;

import juego.MObservable;
import juego.VisualGameElement;
import visualesNuevas.GameUtilities;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jaime
 */
public class MButton extends VisualElement implements Clickable, Hoverable{

    private MLabel text;
    private boolean hover;
    private Color color;
    private Color hoverColor;
    private BufferedImage image;
    private BufferedImage hoverImage;
    private MEvent event;

    public MButton(String id, int x, int y, int width, int height, String text, int size, BufferedImage image, BufferedImage hoverImage, MEvent event){

        super(id, x, y, width, height, null);

        this.text = new MLabel("id", x + width / 2 - text.length(), y + height / 2, text, size, null);
        this.color = new Color(0, 0, 0);
        this.hoverColor = new Color(0, 0, 0);
        this.image = image;
        this.hoverImage = hoverImage;
        this.event = event;

        hover = false;
    }

    public MButton(String id, int x, int y, int width, int height, String text, int size, BufferedImage image, BufferedImage hoverImage){

        super(id, x, y, width, height, null);

        this.text = new MLabel("id", x + width / 2 - text.length(), y + height / 2, text, size, null);
        this.color = new Color(0, 0, 0);
        this.hoverColor = new Color(0, 0, 0);
        this.image = image;
        this.hoverImage = hoverImage;
        this.event = event;

        hover = false;
    }

    @Override
    public void draw(Graphics2D g){
        if (image != null && !GameUtilities.DEBUG){

            if (!hover){
                g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
            }else{
                g.drawImage(hoverImage, getX(), getY(), getWidth(), getHeight(), null);
            }

        }else{

            if (color != null){
                g.drawRect(getX(), getY(), getWidth(), getHeight());
                text.draw(g);
            }
        }

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
        int w = getWidth();
        int h = getHeight();

        return p.x >= x && p.x <= x + w && p.y >= y && p.y <= y + h;
    }

    public void executeEvent(){
        FlatEvent flatEvent = (FlatEvent) event;
        flatEvent.executeEvent();
    }
    public void executeEvent(Point p){
        ClickEvent clickEvent = (ClickEvent) event;
        clickEvent.executeClickEvent(p);
    }

    public void activateHover(){hover = true;}
    public void deactivateHover(){hover = false;}

    public void setEvent(MEvent event){
        this.event = event;
    }

    @Override
    public void setUpdate(MObserver update){
        super.setUpdate(update);
    }

    @Override
    public void update(MObservable mo){
        super.update(mo);
    }



    public Color getColor() {
        return (hover) ? hoverColor : color;
    }

    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public MEvent getEvent() {
        return event;
    }
}
