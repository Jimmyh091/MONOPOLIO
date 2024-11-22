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
        
    }
    
    public void addScene(ArrayList<VisualElement> backgrounds, ArrayList<Image> images, ArrayList<Button> buttons, ArrayList<Label> labels){
        scenes.add(new ArrayList[]{backgrounds, images, buttons, labels});
        actualScene = 0;
    }
    
    public void paintScene(Graphics2D g){
        
        for (int i = 0; i < scenes.size(); i++) {
            
            final int switchOpc = i;
            // type of element = Button, Image...
            for (ArrayList<VisualElement> visualElementsList : scenes.get(i)) {
                
                // every element of the type
                visualElementsList.forEach(element ->{
                
                    switch(switchOpc){
                        case 0 -> { //? seguro que cambiara porque el fondo no creo que sea siempre una imagen
                            
                            Image background = (Image) element;
                            
                            g.drawImage(background.getBi(), background.getX(), background.getY(), background.getWidth(), background.getHeight(), null);
                            
                        }
                        
                        case 1 -> {
                            
                            Image background = (Image) element;
                            
                            g.drawImage(background.getBi(), background.getX(), background.getY(), background.getWidth(), background.getHeight(), null);
                            
                        }
                        
                        
                        case 2 -> {
                            
                            Button button = (Button) element;
                            
                            g.setColor(button.getColor());
                            g.drawRect(button.getX(), button.getY(), button.getWidth(), button.getHeight());
                            
                        }
                        
                        case 3 -> {
                            
                            Label text = (Label) element;
                            
                            g.drawString(text.getText(), text.getX(), text.getY());
                            
                        }
                        
                    }
                
                });
                
            }
                    
        };
            
        ArrayList<VisualElement>[] visualElementsList = scenes.get(actualScene); 

        for (int i = 0; i < visualElementsList.length; i++){

            final int switchOpc = i;
            
            // type of element = Button, Image...
            for (ArrayList<VisualElement> elements : visualElementsList) {

                // every element of the type
                elements.forEach(element -> {

                    switch(switchOpc){
                        case 0 -> { //? seguro que cambiara

                            Image background = (Image) element;

                            g.drawImage(background.getBi(), background.getX(), background.getY(), background.getWidth(), background.getHeight(), null);

                        }

                        case 1 -> {

                            Image background = (Image) element;

                            g.drawImage(background.getBi(), background.getX(), background.getY(), background.getWidth(), background.getHeight(), null);

                        }


                        case 2 -> {

                            Button button = (Button) element;

                            g.setColor(button.getColor());
                            g.drawRect(button.getX(), button.getY(), button.getWidth(), button.getHeight());

                        }

                        case 3 -> {

                            Label text = (Label) element;

                            g.drawString(text.getText(), text.getX(), text.getY());

                        }

                    }
                });

            }                
        }
            
        };
        
    
}
