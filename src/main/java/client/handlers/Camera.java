package client.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Camera implements KeyListener {
    public boolean left, right, forward, back;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent key) {
        if ((key.getKeyCode() == KeyEvent.VK_LEFT)) {
            left = true;
        }
        if ((key.getKeyCode() == KeyEvent.VK_RIGHT)) {
            right = true;
        }
        if ((key.getKeyCode() == KeyEvent.VK_UP)) {
            forward = true;
        }
        if ((key.getKeyCode() == KeyEvent.VK_DOWN)) {
            back = true;
        }
    }

    public void keyReleased(KeyEvent key) {
        if ((key.getKeyCode() == KeyEvent.VK_LEFT)) {
            left = false;
        }
        if ((key.getKeyCode() == KeyEvent.VK_RIGHT)) {
            right = false;
        }
        if ((key.getKeyCode() == KeyEvent.VK_UP)) {
            forward = false;
        }
        if ((key.getKeyCode() == KeyEvent.VK_DOWN)) {
            back = false;
        }
    }
}
