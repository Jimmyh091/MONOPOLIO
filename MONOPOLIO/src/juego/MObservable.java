package juego;

import elementosVisuales.VisualElement;

import java.util.Observer;

public abstract class MObservable {

    VisualElement ve;

    public void addObserver(VisualElement ve) {
        this.ve = ve;
    }

    public void updateObserver(){
        ve.update();
    }

    public VisualElement getVe() {
        return ve;
    }
}
