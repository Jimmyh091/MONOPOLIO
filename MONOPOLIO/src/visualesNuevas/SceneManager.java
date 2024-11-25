/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualesNuevas;

import elementosVisuales.*;
import elementosVisuales.Button;
import elementosVisuales.Image;
import elementosVisuales.Label;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author jaime
 */
public class SceneManager {
    
    private ArrayList<ArrayList<VisualElement>[]> scenes;
    private int actualScene;

    public SceneManager(){

        scenes = new ArrayList<>();
        actualScene = 0;

    }

    public SceneManager(ArrayList<VisualElement>[] scene){

        scenes = new ArrayList<>(); //t convert to hashmap
        scenes.add(scene);
        actualScene = 0;

    }

    public void nextScene(){actualScene++;}
    public void previousScene(){actualScene--;}
    public void setScene(int scene){
        actualScene = scene; //t comprobar si hay suficientes escenas
    }

    public void addScene(ArrayList<VisualElement> backgrounds, ArrayList<Image> images, ArrayList<Button> buttons, ArrayList<Label> labels){

        scenes.add(new ArrayList[]{backgrounds, images, buttons, labels});

    }

    public void paintScene(Graphics2D g){
        
        ArrayList<VisualElement>[] visualElementsList = scenes.get(actualScene); 

        for (int i = 0; i < visualElementsList.length; i++){
            
            ArrayList<VisualElement> elements = visualElementsList[i];

            if (elements != null) elements.forEach(element -> {
                if (element != null) element.draw(g);
            });
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