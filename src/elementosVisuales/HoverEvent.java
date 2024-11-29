package elementosVisuales;

import java.awt.*;

@FunctionalInterface
public interface HoverEvent extends MEvent {
    public void executeHoverEvent(Point p);
}
