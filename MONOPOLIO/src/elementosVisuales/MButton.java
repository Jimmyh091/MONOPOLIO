/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosVisuales;

import juego.VisualGameElement;
import visualesNuevas.GamePanel;
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
    private Event event;

    public MButton(String id, int x, int y, int width, int height, String nombre, int size, BufferedImage image, BufferedImage hoverImage, Event event){

        super(id, x, y, width, height, null);

        this.text = new MLabel("id", x + width / 2 - 18, y + height / 2, null, nombre, size);
        this.color = null;
        this.hoverColor = null;
        this.image = image;
        this.hoverImage = hoverImage;
        this.event = event;

        hover = false;
    }

    public MButton(String id, int x, int y, int width, int height, String text, int size, Color color, Color hoverColor, Event event){ // nunca lo usare si no fuera en debug y para el debug ya tengo el de abajo
        //t
        super(id, x, y, width, height, null);

        this.text = new MLabel(id, x, y, null, text, size); //t deberia estar en el centro
        this.color = color;
        this.hoverColor = hoverColor;
        this.image = null;
        this.hoverImage = null;
        this.event = event;

        hover = false;
    }

    public MButton(String id, int x, int y, int width, int height, String text, int size, Color color, Event event){
        //t
        super(id, x, y, width, height, null);

        this.text = new MLabel(id, x + width / 2 - text.length(), y + height / 2 - size / 2, null, text, size); //t deberia estar en el centro
        this.color = color;
        this.hoverColor = color;
        this.image = null;
        this.hoverImage = null;
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
            g.drawRect(getX(), getY(), getWidth(), getHeight());
            text.draw(g);
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
        event.executeEvent();
    }
    public void activateHover(){hover = true;}
    public void deactivateHover(){hover = false;}

    @Override
    public void update(VisualGameElement vge){
        super.update(vge);
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

    public void setUpdate(MObserver update){
        super.setUpdate(update);
    }
}
