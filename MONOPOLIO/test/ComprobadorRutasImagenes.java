import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ComprobadorRutasImagenes extends JFrame {

    public ComprobadorRutasImagenes(String path) {
        this.setVisible(true);
        this.setTitle("Comprobador Rutas");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 450, 300);

        BufferedImage image = null;

        try {
            image = hola.getImage(path);
        } catch (Exception e) {
            System.out.println("puto");
            throw new RuntimeException(e);
        }

        JLabel lblImagen = new JLabel();
        lblImagen.setIcon(new ImageIcon(image));

        this.add(lblImagen);

        this.pack();

    }

    public static void main(String[] args) {
        new ComprobadorRutasImagenes("/imagenes/test/botonPrueba.png");

    }

    public class hola{

        private static BufferedImage getImage(String path){
            try{
                return ImageIO.read(hola.class.getResourceAsStream(path));
            }catch (Exception e){
                return null;
            }
        }

    }

}
