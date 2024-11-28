package visualesNuevas;

import elementosVisuales.*;
import juego.*;
import visualesInutilizables.PantallaJuego;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SceneImplementer {

    private GameManager gameManager;

    public SceneImplementer(GameManager gameManager) {

        this.gameManager = gameManager;

    }

    public ArrayList<VisualElement>[] addTest(SceneManager sceneManager) {

        MBackground fondoPrueba = new MBackground("fond", new GradientPaint(0, 0, new Color(100, 255, 100), 0, GamePanel.SCREEN_HEIGHT, new Color(200, 255, 200)));

        MLabel labelPrueba = new MLabel("prueba", 0, 30, "SOY UNA PRUEBAAA", 30,null);

        MButton botonPrueba = new MButton("botonPrueba",
                0, 0, 100, 100,
                "Prueba", 16,
                (BufferedImage) null,
                null,
                (FlatEvent) () -> System.out.println("JAIME FUNCIONA QUE COJONES"));
        MButton botonPrueba2 = new MButton("botonPrueba2",
                100, 500, 500, 200,
                "BotonPrueba", 16,
                GameUtilities.getImage("/imagenes/test/botonPrueba.png"),
                GameUtilities.getImage("/imagenes/test/botonPruebaHover.jpg"),
                (FlatEvent) () -> System.out.println("hola"));

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

    public ArrayList<VisualElement>[] addTestSquaresPos(SceneManager sceneManager){

        MButton[] lista = new MButton[41];

        Point[][] p = gameManager.getGameboard().asignPoints();

        for (int i = 0; i < gameManager.getNumSquares(); i++) {
            lista[i] = new MButton("asdf",
                    p[0][i].x, p[0][i].y, p[1][i].x, p[1][i].y,
                    "b" + i, 10,
                    (BufferedImage) null,
                    null,
                    null);
        }

        lista[40] = new MButton("asdf",
                gameManager.getGameboard().getX(), gameManager.getGameboard().getY(), gameManager.getGameboard().getWidth(), gameManager.getGameboard().getHeight(),
                "Tablero", 20,
                (BufferedImage) null,
                null,
                null);

        ArrayList<VisualElement> backgrounds = new ArrayList<>();
        ArrayList<VisualElement> buttons = new ArrayList<>();
        ArrayList<VisualElement> images = new ArrayList<>();
        ArrayList<VisualElement> labels = new ArrayList<>();

        backgrounds.add(null);

        buttons.addAll(Arrays.asList(lista));

        images.add(null);

        labels.add(null);

        return new ArrayList[]{backgrounds, images, buttons, labels};
    }

    public ArrayList<VisualElement>[] addTitleScene(SceneManager sceneManager){

        ArrayList<VisualElement> backgrounds = new ArrayList<>();
        ArrayList<VisualElement> buttons = new ArrayList<>();
        ArrayList<VisualElement> images = new ArrayList<>();
        ArrayList<VisualElement> labels = new ArrayList<>();

        backgrounds.add(null);

        buttons.add(new MButton("BotonJugar",
                0, 0, 100, 100,
                "Jugar", 20,
                (BufferedImage) null,
                null,
                (FlatEvent)() -> sceneManager.setScene("pantallaPrincipal") ));

        BufferedImage imagenTablero = null;
        try {
            imagenTablero = ImageIO.read(getClass().getResourceAsStream("/imagenes/tablero.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(PantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
        }

        images.add(new MImage("ImagenTablero",
                0, 0, 0, 0,
                imagenTablero, "imagenalskdfjas", 3));

        labels.add(null);

        return new ArrayList[]{backgrounds, images, buttons, labels};
    }

    public ArrayList<VisualElement>[] addGameScene(SceneManager sceneManager){

        // BUTTONS
        MButton dice = new MButton("dice",
                gameManager.getDiceCube().getX(), gameManager.getDiceCube().getY(), 100, 100,
                "dado", 10,
                GameUtilities.getImage("/imagenes/tablero.jpg"),
                GameUtilities.getImage("/imagenes/tablero.jpg"),
                (FlatEvent) () -> gameManager.rollDice()); //t coordenadas mal e imagen
        dice.setUpdate(mo -> {
                CuboDados cd = (CuboDados) mo;

                switch (cd.getResult()[0]){ // esto para un dado y seria otro dice para la otra tirada
                    case 1 -> dice.setImage(GameUtilities.getImage("imagendadotirada")); //t
                }

            });

        Gameboard gameboardAux = gameManager.getGameboard();
        // IMAGES

        int a = gameboardAux.getX() + gameboardAux.getWidth();
        int b = GamePanel.SCREEN_WIDTH;
        int c = b - a;
        int d = a + (c / 2) - (300 / 2);

        MImage imagenCalle = new MImage("imagenCalle",
                d, 300, 300, 550,
                GameUtilities.getImage("imagenes/pantallaJuego/carta.jpg"),
                "imagenCalle", 30);
        imagenCalle.setUpdate(mo -> {
            Casilla casilla = (Casilla) mo;
            imagenCalle.setName(casilla.getTitle());
        });

        // BUTTONS pero despues porque tengo que inicializar la imagen

        MButton gameboard = new MButton("gameboard",
                gameboardAux.getX(), gameboardAux.getY(), gameboardAux.getWidth(), gameboardAux.getHeight(),
                "Tablero", 30,
                GameUtilities.getImage("/imagenes/tablero.jpg"),
                GameUtilities.getImage("/imagenes/tablero.jpg"));
        gameboard.setEvent((ClickEvent) click -> {

            Casilla[] casillas = gameboardAux.getSquares();

            for (Casilla casilla : casillas) {

                if (click.x >= casilla.getX() && click.x <= casilla.getX() + casilla.getWidth()){
                    if (click.y >= casilla.getY() && click.y <= casilla.getY() + casilla.getHeight()){
                        gameboard.updateObserver(casilla);
                    }
                }
            }

        });
        gameboard.setUpdate((mo) -> {
            // no tiene pinta que el tablero se vaya a actualizar
        });

        // OBSERVERS //

        gameManager.getDiceCube().addObserver(dice);
        gameboard.addObserver(imagenCalle);

        // --- //

        ArrayList<VisualElement> backgrounds = new ArrayList<>();
        ArrayList<VisualElement> buttons = new ArrayList<>();
        ArrayList<VisualElement> images = new ArrayList<>();
        ArrayList<VisualElement> labels = new ArrayList<>();

        backgrounds.add(null);

        buttons.add(dice);
        buttons.add(gameboard);

        images.add(imagenCalle);

        labels.add(null);

        return new ArrayList[]{backgrounds, images, buttons, labels};
    }
}
