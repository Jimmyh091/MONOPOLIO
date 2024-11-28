package elementosVisuales;

import java.util.HashMap;

public class MGrouper {
    
    private HashMap<String, VisualElement> visualElementsList;
    
    public MGrouper(VisualElement... visualElements) {
        visualElementsList = new HashMap<>();
        for (VisualElement ve : visualElements) {
            visualElementsList.put(ve.getId(), ve);
        }
    }
    
    public MGrouper() {
        visualElementsList = new HashMap<>();
    }

    public void addVisualElement(VisualElement ve){
        visualElementsList.put(ve.getId(), ve);
    }
}
