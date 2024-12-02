package elementosVisuales;

import java.awt.*;
import java.util.HashMap;

public class MGrouper extends VisualElement {

    private HashMap<String, VisualElement> visualElementsList;

    public MGrouper(String id, int x, int y, int w, int h) {
        super(id, x, y, w, h, null);
        visualElementsList = new HashMap<>();
    }

    public void setElements(VisualElement... visualElements) {
        for (VisualElement ve : visualElements) {
            visualElementsList.put(ve.getId(), ve);
        }
    }

    public void addVisualElement(VisualElement ve){
        visualElementsList.put(ve.getId(), ve);
    } //? creo que nunca lo usare

    public HashMap<String, VisualElement> getVisualElementsList() {
        return visualElementsList;
    }

    @Override
    public void setUpdate(MObserver update){
        super.setUpdate(update);
    }

    @Override
    public void draw(Graphics2D g) {
        visualElementsList.forEach((key, value) -> {
            value.draw(g);
        });
    }
}
