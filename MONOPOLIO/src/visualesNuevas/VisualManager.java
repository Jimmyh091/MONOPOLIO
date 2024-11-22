/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualesNuevas;

import elementosVisuales.Button;
import elementosVisuales.Image;
import elementosVisuales.Label;
import elementosVisuales.VisualElement;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author jaime
 */
public class VisualManager {
    
    private ArrayList<ArrayList<VisualElement>[]>scenes;
    private int actualScene;
    
    public VisualManager(){
        
        scenes = new ArrayList<>();
        actualScene = 0;
    }
    
    public void addScene(ArrayList<VisualElement> backgrounds, ArrayList<Image> images, ArrayList<Button> buttons, ArrayList<Label> labels){
        
        scenes.add(new ArrayList[]{backgrounds, images, buttons, labels});
        
    }
    
    public void paintScene(Graphics2D g){
        
        ArrayList<VisualElement>[] visualElementsList = scenes.get(actualScene); 

        for (int i = 0; i < visualElementsList.length; i++){
            
            ArrayList<VisualElement> elements = visualElementsList[i];
            
            elements.forEach(element -> element.draw(g));
        }
            
    }
    
    public void checkClickPosition(Point p){ //? no solo los botones tendrian eventos
        scenes.get(actualScene)[2].forEach(FakeButton -> {
            
            Button button = (Button) FakeButton;
            
            if (button.clicked(p)) {
                button.executeEvent();
            }
        });
    }

    void checkHoverPosition(Point mousePosition) {
        
    }
}