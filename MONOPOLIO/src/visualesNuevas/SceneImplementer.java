package visualesNuevas;

import elementosVisuales.MButton;
import elementosVisuales.MImage;
import elementosVisuales.MLabel;
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

    private GameManager gameManager;

    public SceneImplementer(GameManager gameManager) {

        this.gameManager = gameManager;

    }

    public ArrayList<VisualElement>[] addTest(SceneManager sceneManager) {

        MLabel labelPrueba = new MLabel("prueba", 0, 10, "SOY UNA PRUEBAAA");

        MButton botonPrueba = new MButton("botonPrueba", 0, 0, 100, 100, "Prueba", new Color(20,20,200), new Color(0,0,0), () -> System.out.println("JAIME FUNCIONA QUE COJONES"));
        MButton botonPrueba2 = new MButton("botonPrueba2", 100, 500, 500, 200, "Pruebilla", getImage("/imagenes/test/botonPrueba.png"), getImage("/imagenes/test/botonPruebaHover.jpg"), () -> System.out.println("hola"));

        // --- //

        ArrayList<VisualElement> backgrounds = new ArrayList<>();
        ArrayList<VisualElement> buttons = new ArrayList<>();
        ArrayList<VisualElement> images = new ArrayList<>();
        ArrayList<VisualElement> labels = new ArrayList<>();

        backgrounds.add(null);

        buttons.add(botonPrueba);
        buttons.add(botonPrueba2);

        images.add(null);

        labels.add(labelPrueba);

        return new ArrayList[]{backgrounds, images, buttons, labels};
    }

    private ArrayList<VisualElement>[] addTitleScene(SceneManager sceneManager){

        ArrayList<VisualElement> backgrounds = new ArrayList<>();
        ArrayList<VisualElement> buttons = new ArrayList<>();
        ArrayList<VisualElement> images = new ArrayList<>();
        ArrayList<VisualElement> labels = new ArrayList<>();

        backgrounds.add(null);

        buttons.add(new MButton("BotonJugar", 0, 0, 100, 100, "Jugar", new Color(0,0,0), new Color(0,0,0), () -> sceneManager.setScene("pantallaPrincipal") ));

        BufferedImage imagenTablero = null;
        try {
            imagenTablero = ImageIO.read(getClass().getResourceAsStream("/imagenes/tablero.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(PantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
        }

        images.add(new MImage("ImagenTablero", 0, 0, imagenTablero));

        labels.add(null);

        return new ArrayList[]{backgrounds, images, buttons, labels};
    }

    private ArrayList<VisualElement>[] addGameScene(SceneManager sceneManager){

        // BUTTONS
        MButton botonJugar = new MButton("BotonJugar", 0, 0, 100, 100, "Jugar", new Color(0,0,0), new Color(20,20,20), () -> sceneManager.setScene("pantallaPrincipal") );

        // IMAGES
        MImage imagenTablero = new MImage("imagenTablero", 0, 0, getImage("/elementos/imagenes/tablero.jpg"));

        ArrayList<VisualElement> backgrounds = new ArrayList<>();
        ArrayList<VisualElement> buttons = new ArrayList<>();
        ArrayList<VisualElement> images = new ArrayList<>();
        ArrayList<VisualElement> labels = new ArrayList<>();

        backgrounds.add(null);

        buttons.add(botonJugar);

        images.add(imagenTablero);

        labels.add(null);

        return new ArrayList[]{backgrounds, images, buttons, labels};
    }

    private BufferedImage getImage(String path){
       try{
            return ImageIO.read(getClass().getResourceAsStream(path));
        }catch (Exception e){
            return null;
        }
    }
}
