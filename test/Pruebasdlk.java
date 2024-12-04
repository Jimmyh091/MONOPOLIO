
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaime
 */
public class Pruebasdlk {

    public Pruebasdlk() {



    }

    public static class Pr{

        public Pr(){

        }

        public void quienSoy(){
            System.out.println("SOY PR");
        }
    }

    public static class ueba extends Pr{

        public ueba(){
            super();
        }

    }

    public static void main(String[] args) {

        ueba ueba = new ueba();
        ueba.quienSoy();

    }
}
