/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elementosVisuales;

import java.awt.Point;

/**
 *
 * @author jaime
 */
public interface Hoverable extends PositionChecker{
    @Override
    public boolean pointIn(Point p);
    public boolean mouseIn(Point p);
    public void activateHover();
    public void deactivateHover();
}
