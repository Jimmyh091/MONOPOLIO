package juego;

import elementosVisuales.VisualElement;

import java.awt.image.BufferedImage;

public class VisualGameElement extends MObservable {

    private int x, y, width, height;
    private BufferedImage image;

    public VisualGameElement(int x, int y, int width, int height, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    //? no se porque se le pondria override si hace solo lo que hace el padre
    @Override
    public void addObserver(VisualElement ve){
        super.addObserver(ve);
    }

    @Override
    public void updateObserver(MObservable mo) {
        super.updateObserver(mo);
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

    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
