/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualesNuevas;

import elementosVisuales.*;

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
    
    public void checkClickPosition(Point clickPosition){ //? no solo los botones tendrian eventos
        scenes.get(actualScene)[2].forEach(button1 -> {
            
            Button button = (Button) button1;
            
            if (button.clickIn(clickPosition)) {
                button.executeEvent();
            }
        });
    }

    void checkHoverPosition(Point mousePosition) { //? puede no ser solo imagenes y botones
        for (ArrayList<VisualElement> typeElement : scenes.get(actualScene)) {

            if (typeElement.getFirst() instanceof Hoverable) {
                scenes.get(actualScene)[2].forEach(button1 -> {

                    Button button = (Button) button1;

                    if (button.mouseIn(mousePosition)) {
                        button.activateHover();
                    }else{
                        button.deactivateHover();
                    }
                });
            }

        }
        scenes.get(actualScene)[2].forEach(button1 -> {

        });
    }

    /* //? tendra sentido
    private void checkInterfacePosition(Class c){
        for (ArrayList<VisualElement> typeElement : scenes.get(actualScene)) {

            if (c.isInstance(typeElement.getFirst())) {

                typeElement.forEach(element -> {

                    element.

                    if (element.clickIn(p)) {
                        button.executeEvent();
                    }
                });
            }

        }
    }
    */

}