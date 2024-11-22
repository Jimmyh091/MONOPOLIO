/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualesNuevas;

import elementosVisuales.VisualElement;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author jaime
 */
public class VisualManager {
    
    private ArrayList<ArrayList<VisualElement>[]>scenes;
    
    public VisualManager(){
        
        scenes = new ArrayList<>();
        
    }
    
    public void addScene(ArrayList<VisualElement> backgrounds, ArrayList<VisualElement> images, ArrayList<VisualElement> buttons, ArrayList<VisualElement> labels){
        scenes.add(new ArrayList[]{backgrounds, images, buttons, labels});
    }
    
    public void paintScene(Graphics2D g){
        
        scenes.forEach();
        
    }
}
