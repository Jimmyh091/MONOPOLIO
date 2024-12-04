package juego;

import elementosVisuales.MObserver;
import elementosVisuales.VisualElement;

import java.util.HashMap;

public abstract class MObservable {

    HashMap<String, VisualElement> visualElements;

    public MObservable() {
        visualElements = new HashMap<>();
    }

    public void addObserver(String name, VisualElement ve) {
        visualElements.put(name, ve);
    }

    public void updateObserver(String name, MObservable mo){
        visualElements.get(name).update(mo);
    }

    public VisualElement getVe(String name) {
        return visualElements.get(name);
    }
}
