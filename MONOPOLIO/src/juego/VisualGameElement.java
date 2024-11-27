package juego;

import elementosVisuales.VisualElement;

import java.awt.image.BufferedImage;
import java.util.Observer;

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


    //? ??????????????
    @Override
    public void addObserver(VisualElement ve){
        super.addObserver(ve);
    }

    @Override
    public void updateObserver() {
        super.updateObserver();
    }
}
