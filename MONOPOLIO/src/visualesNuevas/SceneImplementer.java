package visualesNuevas;

import elementosVisuales.Button;
import elementosVisuales.Image;
import elementosVisuales.VisualElement;
import juego.Gameboard;
import visualesInutilizables.PantallaJuego;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        buttons.add(new Button("BotonJugar", 0, 0, 100, 100, "Jugar", new Color(0,0,0), () -> visualManager.nextScene() ));

        BufferedImage imagenTablero = null;
        try {
            imagenTablero = ImageIO.read(getClass().getResourceAsStream("/elementos/imagenes/tablero.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(PantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
        }

        images.add(new Image("ImagenTablero", 0, 0, imagenTablero));

        labels.add(null);

        return new ArrayList[]{backgrounds, buttons, images, labels};
    }

    private ArrayList<VisualElement>[] addGameScene(){

        // BUTTONS
        // Button botonJugar = new Button("BotonJugar", 0, 0, 100, 100, "Jugar", new Color(0,0,0), () -> visualManager.nextScene() )

        // IMAGES
        BufferedImage imagenTablero = null;
        try {
            imagenTablero = ImageIO.read(getClass().getResourceAsStream("/elementos/imagenes/tablero.jpg"));
            new Image("ImagenTablero", 0, 0, imagenTablero);
        } catch (IOException ex) {
            Logger.getLogger(PantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<VisualElement> backgrounds = new ArrayList<>();
        ArrayList<VisualElement> buttons = new ArrayList<>();
        ArrayList<VisualElement> images = new ArrayList<>();
        ArrayList<VisualElement> labels = new ArrayList<>();

        backgrounds.add(null);

        buttons.add();

        images.add(new Image("ImagenTablero", 0, 0, imagenTablero));

        labels.add(null);

        return new ArrayList[]{backgrounds, buttons, images, labels};
    }

    private BufferedImage getImage(String path){
        try{
           return ImageIO.read(getClass().getResourceAsStream(path));
        }catch (Exception e){

        }
        return null;
    }
}
