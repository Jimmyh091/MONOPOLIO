package visualesNuevas;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class GameUtilities {
    public static boolean DEBUG = false;

    public static BufferedImage getImage(String path){
        try{
            return ImageIO.read(GameUtilities.class.getResourceAsStream(path));
        }catch (Exception e){
            return null;
        }
    }
}
