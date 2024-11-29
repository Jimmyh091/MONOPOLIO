package elementosVisuales;

import java.awt.Point;

@FunctionalInterface
public interface ClickEvent extends MEvent {
    public void executeClickEvent(Point clickPoint); // no es necesario porque hara lo que hace position
}
