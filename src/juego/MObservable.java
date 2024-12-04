package juego;

import elementosVisuales.MObserver;
import elementosVisuales.VisualElement;

public abstract class MObservable {

    VisualElement[] ve;

    public void addObserver(VisualElement... ve) {
        this.ve = ve;
    }

    public void updateObserver(MObservable mo, int position){
        ve[position].update(mo);
    }

    public VisualElement getVe(int postition) {
        return ve[postition];
    }
}
