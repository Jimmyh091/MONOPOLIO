package elementosVisuales;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MBackground extends VisualElement{

    private Color color;
    private GradientPaint gradient;
    private BufferedImage image;

    public MBackground(String id, int x, int y, int width, int height, Color color) {

    }

    public MBackground(String id, int x, int y, int width, int height, GradientPaint gradient) {

    }

    public MBackground(String id, int x, int y, BufferedImage b, int e){
        super(id,x,y,b.getWidth(),b.getHeight());
    }


/*
    public MImage(String id, int x, int y, BufferedImage b){
        super(id, x, y, b.getWidth(), b.getHeight());
        bi = b;
    }

    public MImage(String id, int x, int y, int w, int h, BufferedImage b){
        super(id, x, y, w, h);
        bi = b;
    }

    public MBackground(String id, int x, int y, int w, int h, BufferedImage b){

        super.setId(id);
        super.setX(x);
        super.setY(y);
        super.setWidth(w);
        super.setHeight(h);

        bi = b;
    }

    public MBackground() {

    }

 */
    @Override
    public void draw(Graphics2D g) {

    }

}
