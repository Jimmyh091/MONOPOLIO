package elementosVisuales;

import juego.MObservable;
import visualesNuevas.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MBackground extends VisualElement{

    private Color color;
    private GradientPaint gradient;
    private BufferedImage image;

    public MBackground(String id, Color color) {
        super(id, 0, 0, GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT, true, null);
        this.color = color;
    }

    public MBackground(String id, GradientPaint gradient) {
        super(id, 0, 0, GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT, true, null);
        this.gradient = gradient;
    }

    public MBackground(String id, BufferedImage b){
        super(id, 0, 0, GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT, true, null);
    }

    @Override
    public void draw(Graphics2D g) {
        if (image != null){
            g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
        }else if (gradient != null){
            g.setPaint(gradient);
            g.fillRect(0, 0, GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT);
        }else{
            g.setPaint(color);
            g.fillRect(0, 0, GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT);
        }
    }

    @Override
    public void update(MObservable mo) {
        //? ?????????????
    }
}
