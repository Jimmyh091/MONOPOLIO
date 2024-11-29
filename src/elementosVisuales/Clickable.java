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

public interface Clickable extends PositionChecker, ClickEvent{ //? quiero que haga lo que hace clickEvent pero que no herede porque no es un eveto
    @Override
    public boolean pointIn(Point p);
    public boolean clickIn(Point p); // no es necesario pero me gusta mas ordenado
    @Override
    public void executeClickEvent(Point clickPoint);
}
