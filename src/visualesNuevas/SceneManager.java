/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualesNuevas;

import elementosVisuales.*;
import elementosVisuales.MButton;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jaime
 */
public class SceneManager {
    
    private HashMap<String, ArrayList<VisualElement>[]> scenes;
    private String actualScene;

    public SceneManager(){ //? creo que nunca se va a usar

        scenes = new HashMap<>();
        actualScene = "";

    }

    public SceneManager(String nombre, ArrayList<VisualElement>[] scene){

        scenes = new HashMap<>(); //t convert to hashmap
        scenes.put(nombre, scene);
        actualScene = nombre;

    }

    public void setScene(String nombre){
        actualScene = nombre; //t comprobar si hay suficientes escenas
    }

    public void addScene(String nombre, ArrayList<VisualElement>[] scene){

        scenes.put(nombre, scene);
        actualScene = nombre;

    }

    public void paintScene(Graphics2D g){
        
        ArrayList<VisualElement>[] visualElementsList = scenes.get(actualScene); 

        if (visualElementsList != null){

            for (int i = 0; i < visualElementsList.length; i++){

                ArrayList<VisualElement> elements = visualElementsList[i];

                if (elements != null) elements.forEach(element -> {

                    if (element != null && element.isActive()) element.draw(g);
                });
            }

        }
    }
    
    public void checkClickPosition(Point clickPosition){ //? no solo los botones tendrian eventos

        if (scenes.get(actualScene) != null){

            if (scenes.get(actualScene)[2].get(0) != null){ //? seria mejor hacer esta comprobacion dentro del foreach supongo pero tambien me convence asi

                scenes.get(actualScene)[2].forEach(element -> {

                    if (element.isActive()){

                        if (element instanceof Clickable){

                            Clickable clickable = (Clickable) element;

                            if (clickable.clickIn(clickPosition)) {

                                clickable.executeClickEvent(clickPosition);

                            }
                        }
                    }
                });
            }
        }
    }

    void checkHoverPosition(Point mousePosition) { //? puede no ser solo imagenes y botones
        if (scenes.get(actualScene) != null) {

            for (ArrayList<VisualElement> typeElement : scenes.get(actualScene)) {

                typeElement.forEach(element -> {

                    if (element.isActive()) {

                        if (element instanceof Hoverable) {

                            Hoverable hoverable = (Hoverable) element;
                            if (hoverable.mouseIn(mousePosition)) {
                                hoverable.activateHover();
                            } else {
                                hoverable.deactivateHover();
                            }

                        }
                        if (element instanceof HoverEvent) {

                            HoverEvent hoverEvent = (HoverEvent) element;
                            hoverEvent.executeHoverEvent(mousePosition);

                        }
                    }
                });
            }
        }
    }
}