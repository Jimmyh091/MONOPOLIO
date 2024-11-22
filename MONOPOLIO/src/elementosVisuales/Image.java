/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosVisuales;

import java.awt.image.BufferedImage;

/**
 *
 * @author EAG
 */
public class Image extends VisualElement{
    private final BufferedImage bi;
    
    public Image(int x, int y, int w, int h, BufferedImage b){
        super.setX(x);
        super.setY(y);
        super.setWidth(w);
        super.setHeight(h);
        
        bi = b;
    }

    public BufferedImage getBi() {
        return bi;
    }
}
