/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.view;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class MouseListener extends MouseAdapter implements MouseMotionListener {

    private static MouseListener instance;
    private List<Point> mouseCoordinates = new ArrayList<>();

    public List<Point> getMouseCoordinates() {
        return mouseCoordinates;
    }

    public void addMouseCoordinate(Point coordinate) {
        mouseCoordinates.add(coordinate);
    }

    private MouseListener() {
    }

    public static MouseListener get() {
        if (MouseListener.instance == null) {
            MouseListener.instance = new MouseListener();
        }

        return MouseListener.instance;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (Sprite sprite : Display.getSprites()) {
            if (sprite.getBounds().contains(e.getPoint())) {
                sprite.setIsDragging(true);
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (Sprite sprite : Display.getSprites()) {
            sprite.setIsDragging(false);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Point coordinate = new Point(x, y);
        addMouseCoordinate(coordinate);
        System.out.println("Mouse X: " + x + ", Mouse Y: " + y);

        for (Sprite sprite : Display.getSprites()) {
            if (sprite.isDragging()) {
                sprite.updatePosition(x, y);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Point coordinate = new Point(x, y);
        addMouseCoordinate(coordinate);
        System.out.println("Mouse X: " + x + ", Mouse Y: " + y);
    }

    public void getCords() {
        List<Point> coordinates = MouseListener.get().getMouseCoordinates();
        for (Point coordinate : coordinates) {
            System.out.println("X: " + coordinate.getX() + ", Y: " + coordinate.getY());
        }
    }

}
