/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosVisuales;

import juego.VisualGameElement;

import java.awt.Graphics2D;

/**
 *
 * @author EAG
 */
public abstract class VisualElement implements Drawable, MObserver{

    private String id;
    private int x;
    private int y;
    private int width;
    private int height;

    private MObserver update;

    public VisualElement(String id, int x, int y, int width, int height, MObserver update) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.update = update;
    }

    @Override
    public abstract void draw(Graphics2D g);

    @Override
    public void update(VisualGameElement vgm){
        update.update(vgm);
    }

    public void setUpdate(MObserver update){
        this.update = update;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
