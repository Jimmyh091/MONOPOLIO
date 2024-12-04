package elementosVisuales;

import java.awt.*;
import java.util.ArrayList;

public class MGrouper extends VisualElement {

    private ArrayList<VisualElement> visualElementsList;

    public MGrouper(String id, int x, int y, int w, int h, FlatEvent updateEvent) {
        super(id, x, y, w, h, updateEvent);
        visualElementsList = new ArrayList<>();
    }

    public void addElements(VisualElement... visualElements) {
        for (VisualElement ve : visualElements) {
            visualElementsList.add(ve);
        }
    }

    public void addElement(VisualElement ve){
        visualElementsList.add(ve);
    } //? creo que nunca lo usare

    public ArrayList<VisualElement> getVisualElementsList() {
        return visualElementsList;
    }

    public void activate(){
        super.setActive(true);
        visualElementsList.forEach(element -> {
            element.setActive(true);
        });
    }
    public void deactivate(){
        super.setActive(false);
        visualElementsList.forEach(element -> {
            element.setActive(false);
        });
    }

    @Override
    public void setUpdate(MObserver update){
        super.setUpdate(update);
    }

    @Override
    public void draw(Graphics2D g) {
        visualElementsList.forEach(element -> {
            element.draw(g);
        });
    }
}
