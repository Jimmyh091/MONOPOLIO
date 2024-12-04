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
import java.util.logging.Level;
import java.util.logging.Logger;

public class SceneImplementer {

    private GameManager gameManager;

    public SceneImplementer(GameManager gameManager) {

        this.gameManager = gameManager;

    }

    public ArrayList<VisualElement>[] addTest(SceneManager sceneManager) {

        MBackground fondoPrueba = new MBackground("fond", new GradientPaint(0, 0, new Color(100, 255, 100), 0, GamePanel.SCREEN_HEIGHT, new Color(200, 255, 200)));

        MLabel labelPrueba = new MLabel("prueba", 0, 30, true, "SOY UNA PRUEBAAA", 30);

        MButton botonPrueba = new MButton("botonPrueba",
                0, 0, 100, 100,
                (CheckSceenState) sceenState -> {
                    switch(sceenState.){

                    }
                },
                "Prueba", 16,
                (BufferedImage) null,
                null,
                (FlatEvent) () -> System.out.println("JAIME FUNCIONA QUE COJONES"));
        MButton botonPrueba2 = new MButton("botonPrueba2",
                100, 500, 500, 200, true,
                "BotonPrueba", 16,
                GameUtilities.getImage("/imagenes/test/botonPrueba.png"),
                GameUtilities.getImage("/imagenes/test/botonPruebaHover.jpg"),
                (FlatEvent) () -> System.out.println("hola"));

        // --- //

        ArrayList<MBackground> backgrounds = new ArrayList<>();
        ArrayList<MButton> buttons = new ArrayList<>();
        ArrayList<MImage> images = new ArrayList<>();
        ArrayList<MLabel> labels = new ArrayList<>();
        ArrayList<MGrouper> groupers = new ArrayList<>();

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
                    p[0][i].x, p[0][i].y, p[1][i].x, p[1][i].y, true,
                    "b" + i, 10,
                    (BufferedImage) null,
                    null,
                    null);
        }

        lista[40] = new MButton("asdf",
                gameManager.getGameboard().getX(), gameManager.getGameboard().getY(), gameManager.getGameboard().getWidth(), gameManager.getGameboard().getHeight(), true,
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
                0, 0, 100, 100, true,
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
                0, 0, 0, 0, true,
                imagenTablero, "imagenalskdfjas", 3));

        labels.add(null);

        return new ArrayList[]{backgrounds, images, buttons, labels};
    }

    public ArrayList<VisualElement>[] addGameScene(SceneManager sceneManager){

        boolean probarCoordenadasCasillas = true;

        // BUTTONS
        MButton dice = new MButton("dice",
                gameManager.getDiceCube().getX(), gameManager.getDiceCube().getY(), 100, 100, true,
                "dado", 10,
                GameUtilities.getImage("/imagenes/tablero.jpg"),
                GameUtilities.getImage("/imagenes/tablero.jpg"),
                (ClickEvent) p -> gameManager.rollDice());
        dice.setUpdate(mo -> {
                CuboDados cd = (CuboDados) mo;

                switch (cd.getResult()[0]){ // esto para un dado y seria otro dice para la otra tirada
                    case 1 -> dice.setImage(GameUtilities.getImage("imagendadotirada")); //t
                }

            });

        Gameboard gameboardAux = gameManager.getGameboard();


        /*Prueba de ver la posicion de los botones

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

        /**/


        // IMAGES

        int a = gameboardAux.getX() + gameboardAux.getWidth();
        int b = GamePanel.SCREEN_WIDTH;
        int c = b - a;
        int d = a + (c / 2) - (300 / 2);

        BufferedImage cartaImagen = GameUtilities.getImage("/imagenes/pantallaJuego/carta.jpg");

        MGrouper imagenCalleMG = new MGrouper("groupImagenCalle",
                d, 300, cartaImagen.getWidth(), 550, false);

        MLabel nombreCalle = new MLabel("nombreCalle",
                d + 30, 345, false,
                "", 20);
        nombreCalle.setUpdate(mo -> {
            Casilla casilla = (Casilla) mo;
            nombreCalle.setText(casilla.getTitle());
            //nombreCalle.setX(JustifyWidth.getCenter(nombreCalle.getText(), nombreCalle.getFont().getSize(), imagenCalleMG.getX(), imagenCalleMG.getX() + imagenCalleMG.getWidth()));
        });

        MLabel precioCalle = new MLabel("precioCalle",
                d + 30, 400, false,
                "", 20);
        precioCalle.setUpdate(mo -> {
            Casilla casilla = (Casilla) mo;
            if (casilla instanceof Calle){
                Calle calle = (Calle) casilla;
                precioCalle.setText("Precio: " + calle.getPrice1());
            }
            //nombreCalle.setX(JustifyWidth.getCenter(nombreCalle.getText(), nombreCalle.getFont().getSize(), imagenCalleMG.getX(), imagenCalleMG.getX() + imagenCalleMG.getWidth()));
        });

        MImage imagenCalle = new MImage("imagenCalle",
                d, 300, cartaImagen.getWidth(), cartaImagen.getHeight(), false,//t aqui estaria bien que te pasen las coordenadas relativas, dentro
                cartaImagen,
                "imagenCalle", 30);

        imagenCalleMG.setUpdate(mo -> {
            imagenCalleMG.getVisualElementsList().forEach(element -> {
                element.update(mo);
            });
        });

        imagenCalleMG.addElements(imagenCalle, nombreCalle, precioCalle);

        // BUTTONS pero despues porque tengo que inicializar la imagen

        MButton gameboard = new MButton("gameboard",
                gameboardAux.getX(), gameboardAux.getY(), gameboardAux.getWidth(), gameboardAux.getHeight(), true,
                "Tablero", 30,
                GameUtilities.getImage("/imagenes/tablero.jpg"),
                GameUtilities.getImage("/imagenes/tablero.jpg"));
        gameboard.setEvent((ClickEvent) click -> {

            imagenCalleMG.activate();

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
        gameboard.addObserver(imagenCalleMG);

        // --- //

        ArrayList<MBackground> backgrounds = new ArrayList<>();
        ArrayList<MButton> buttons = new ArrayList<>();
        ArrayList<MImage> images = new ArrayList<>();
        ArrayList<MLabel> labels = new ArrayList<>();
        ArrayList<MGrouper> groupers = new ArrayList<>();

        backgrounds.add(null);

        groupers.add(imagenCalleMG);

        images.add(imagenCalle);

        buttons.add(dice);
        buttons.add(gameboard);
        /* borrable
        if (probarCoordenadasCasillas){
            buttons.addAll(Arrays.asList(lista));
        }

        /* */

        labels.add(null);

        return new ArrayList[]{backgrounds, images, buttons, groupers,  labels};
    }
}
