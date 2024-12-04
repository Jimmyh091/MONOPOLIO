package elementosVisuales;

public class JustifyWidth {

    private int[] letterWeight; //todo meter los pesos

    public static int getCenter(String text, int size, int start, int end){
        return start + ((end - start)/2) - (text.length() * size) / 2; //todo hacer la formula
    }

}
