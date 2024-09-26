/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualesNuevas;

/**
 *
 * @author EAG
 */
public class Button {
    
    private int x;
    private int y;
    private int width;
    private int height;
    private String text;
    private int id;
    private boolean hoverActive;
    
    public Button(int x, int y, int w, int h, String t, int i){
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        text = t;
        id = i;
        hoverActive = false;
    }
    
    protected void triggerHover(){
        hoverActive = !hoverActive;
    }
}
