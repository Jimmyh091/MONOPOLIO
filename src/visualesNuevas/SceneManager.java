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
import java.util.function.Consumer;

/**
 *
 * @author jaime
 */
public class SceneManager {
    
    private HashMap<String, ArrayList<VisualElement>[]> scenes;
    private String actualScene;

    private SceneState currentState;

    public SceneManager(){ //? creo que nunca se va a usar

        scenes = new HashMap<>();
        actualScene = "";
        currentState = SceneState.ROLL_DICE;

    }

    public SceneManager(String nombre, ArrayList<VisualElement>[] scene){

        scenes = new HashMap<>(); //todo convert to hashmap
        scenes.put(nombre, scene);
        actualScene = nombre;

    }

    public void setScene(String nombre){
        actualScene = nombre; //todo comprobar si hay suficientes escenas
        currentState = SceneState.valueOf(actualScene);
    }

    public void updateStateElements(){

        // aqui no se puede utilizar iterateElements porque necesita la posicion
        ArrayList<VisualElement>[] visualElementsList = scenes.get(actualScene);

        if (visualElementsList != null){

            for (int i = 0; i < visualElementsList.length; i++){

                ArrayList<VisualElement> elements = visualElementsList[i];

                final int position = i;

                if (elements != null) elements.forEach(element -> {

                    if (element != null){
                        element.updateScreenState(position, currentState);
                    }else{
                        System.out.println("LOG: ERROR.SceneManager.updateStateElements");
                    }

                });
            }
        }
    }

    public void addScene(String nombre, ArrayList<VisualElement>[] scene){

        scenes.put(nombre, scene);
        actualScene = nombre;

    }

    public void paintScene(Graphics2D g){

        iterateElements(element -> {
            if (element != null && element.isActive()) element.draw(g);
        });

    }
    
    public void checkClickPosition(Point clickPosition){ //? no solo los botones tendrian eventos

        iterateElements(element -> {
            if (element instanceof Clickable){

                Clickable clickable = (Clickable) element;

                if (clickable.clickIn(clickPosition)) {

                    clickable.executeClickEvent(clickPosition);

                }
            }
        });

    }

    void checkHoverPosition(Point mousePosition) { //? puede no ser solo imagenes y botones

        iterateElements(element -> {
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
        });

    }

    private void iterateElements(Iterate iterate){
        ArrayList<VisualElement>[] visualElementsList = scenes.get(actualScene);

        if (visualElementsList != null){

            for (int i = 0; i < visualElementsList.length; i++){

                ArrayList<VisualElement> elements = visualElementsList[i];

                if (elements != null) elements.forEach(iterate::execute);
            }

        }
    }
}