package client.handlers;

import client.Game;
import client.renderables.Drawable;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Camera implements KeyListener, Drawable {
    public boolean left, right, forward, back;
    private int camX, camY;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent key) {
        if ((key.getKeyCode() == KeyEvent.VK_A)) {
            left = true;
        }
        if ((key.getKeyCode() == KeyEvent.VK_D)) {
            right = true;
        }
        if ((key.getKeyCode() == KeyEvent.VK_W)) {
            forward = true;
        }
        if ((key.getKeyCode() == KeyEvent.VK_S)) {
            back = true;
        }
    }

    public void keyReleased(KeyEvent key) {
        if ((key.getKeyCode() == KeyEvent.VK_A)) {
            left = false;
        }
        if ((key.getKeyCode() == KeyEvent.VK_S)) {
            right = false;
        }
        if ((key.getKeyCode() == KeyEvent.VK_W)) {
            forward = false;
        }
        if ((key.getKeyCode() == KeyEvent.VK_S)) {
            back = false;
        }
    }

    @Override
    public void draw(Graphics g) {
        int offsetMaxX = Game.window.getWidth();
        int offsetMaxY = Game.window.getHeight();
        int offsetMinX = 0;
        int offsetMinY = 0;
        camX = Game.window.getWidth() / 2; // TODO: <users player>.getX() -  Game.window.getWidth() / 2;
        camY = Game.window.getHeight() / 2; // TODO: <users player>.getY() -  Game.window.getHeight() / 2;

        if (camX > offsetMaxX) {
            camX = offsetMaxX;
        } else if (camX < offsetMinX) {
            camX = offsetMinX;
            if (camY > offsetMaxY) {
                camY = offsetMaxY;
            }
        } else if (camY < offsetMinY) {
            camY = offsetMinY;
        }
        g.translate(-camX, -camY);
        // TODO: Loop throughout world where <User player> is at.
        g.translate(camX, camY);
    }
}
