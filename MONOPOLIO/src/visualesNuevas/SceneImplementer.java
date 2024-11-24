package visualesNuevas;

import elementosVisuales.Button;
import elementosVisuales.Image;
import elementosVisuales.VisualElement;
import juego.GameManager;
import visualesInutilizables.PantallaJuego;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SceneImplementer {

    private GameManager gameboard;

    public SceneImplementer(GameManager gameboard) {

        this.gameboard = gameboard;

    }

    public ArrayList<VisualElement>[] addTest(SceneManager sceneManager) {

        Button botonPrueba = new Button("botonPrueba", 0, 0, 100, 100, "Prueba", new Color(250,250,250), () -> System.out.println("JAIME FUNCIONA QUE COJOES"));

        ArrayList<VisualElement> backgrounds = new ArrayList<>();
        ArrayList<VisualElement> buttons = new ArrayList<>();
        ArrayList<VisualElement> images = new ArrayList<>();
        ArrayList<VisualElement> labels = new ArrayList<>();

        backgrounds.add(null);

        buttons.add(null);

        images.add(null);

        labels.add(null);

        return new ArrayList[]{backgrounds, buttons, images, labels};
    }

    private ArrayList<VisualElement>[] addTitleScene(SceneManager sceneManager){

        ArrayList<VisualElement> backgrounds = new ArrayList<>();
        ArrayList<VisualElement> buttons = new ArrayList<>();
        ArrayList<VisualElement> images = new ArrayList<>();
        ArrayList<VisualElement> labels = new ArrayList<>();

        backgrounds.add(null);

        buttons.add(new Button("BotonJugar", 0, 0, 100, 100, "Jugar", new Color(0,0,0), () -> sceneManager.nextScene() ));

        BufferedImage imagenTablero = null;
        try {
            imagenTablero = ImageIO.read(getClass().getResourceAsStream("imagenes/tablero.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(PantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
        }

        images.add(new Image("ImagenTablero", 0, 0, imagenTablero));

        labels.add(null);

        return new ArrayList[]{backgrounds, buttons, images, labels};
    }

    private ArrayList<VisualElement>[] addGameScene(SceneManager sceneManager){

        // BUTTONS
        Button botonJugar = new Button("BotonJugar", 0, 0, 100, 100, "Jugar", new Color(0,0,0), () -> sceneManager.nextScene() );

        // IMAGES
        Image imagenTablero = new Image("imagenTablero", 0, 0, getImage("/elementos/imagenes/tablero.jpg"));

        ArrayList<VisualElement> backgrounds = new ArrayList<>();
        ArrayList<VisualElement> buttons = new ArrayList<>();
        ArrayList<VisualElement> images = new ArrayList<>();
        ArrayList<VisualElement> labels = new ArrayList<>();

        backgrounds.add(null);

        buttons.add(botonJugar);

        images.add(imagenTablero);

        labels.add(null);

        return new ArrayList[]{backgrounds, buttons, images, labels};
    }

    private BufferedImage getImage(String path){
        try{
            return ImageIO.read(getClass().getResourceAsStream(path));
        }catch (Exception e){
            return null;
        }
    }
}
