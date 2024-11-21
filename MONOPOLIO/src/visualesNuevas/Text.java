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
public class Text extends VisualElement{
    private String text;
    
    public Text(int x, int y, int w, int h, String t){
        super.setX(x);
        super.setY(y);
        super.setWidth(w);
        super.setHeight(h);
        
        text = t;
    }
}
