package visualesNuevas;

import elementosVisuales.Button;
import elementosVisuales.VisualElement;
import juego.Gameboard;

import java.awt.*;
import java.util.ArrayList;

public class SceneImplementer {

    private Gameboard gameboard;
    private VisualManager visualManager;

    public SceneImplementer(Gameboard gameboard, VisualManager visualManager) {

        this.gameboard = gameboard;
        this.visualManager = visualManager;

    }

    private ArrayList<VisualElement>[] addTitleScene(){

        ArrayList<VisualElement> backgrounds = new ArrayList<>();
        ArrayList<VisualElement> buttons = new ArrayList<>();
        ArrayList<VisualElement> images = new ArrayList<>();
        ArrayList<VisualElement> labels = new ArrayList<>();

        backgrounds.add(null);
        //? ??????????????????????
        Event e = () -> {
            System.out.println("sofa");
        };
        buttons.add(new Button("BotonJugar", 0, 100, 100, "Jugar", new Color(0,0,0), () -> visualManager.nextScene()));

        images.add(null);

        labels.add(null);

        return new ArrayList[]{backgrounds, buttons, images, labels};
    }
}
