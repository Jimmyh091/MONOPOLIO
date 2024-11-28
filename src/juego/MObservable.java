package juego;

import elementosVisuales.VisualElement;

public abstract class MObservable {

    VisualElement ve;

    public void addObserver(VisualElement ve) {
        this.ve = ve;
    }

    public void updateObserver(VisualGameElement vge){
        ve.update(vge);
    }

    public VisualElement getVe() {
        return ve;
    }
}
