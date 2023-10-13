package org.itson.view;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {

    private boolean[] keys;

    public KeyListener() {
        keys = new boolean[256];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode < keys.length) {
            keys[keyCode] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode < keys.length) {
            keys[keyCode] = false;
        }
    }


    public boolean isKeyPressed(int keyCode) {
        if (keyCode >= 0 && keyCode < keys.length) {
            return keys[keyCode];
        } else {
            return false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}

