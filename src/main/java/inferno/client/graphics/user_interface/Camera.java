package inferno.client.graphics.user_interface;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Camera implements KeyListener {
    public boolean left, right, forward, back;


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
}
