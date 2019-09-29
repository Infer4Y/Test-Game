package client.handlers

import client.ClientGame
import client.renderables.Drawable

import java.awt.*
import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class Camera : KeyListener, Drawable {
    var left: Boolean = false
    var right: Boolean = false
    var forward: Boolean = false
    var back: Boolean = false
    private var camX: Int = 0
    private var camY: Int = 0

    override fun keyTyped(e: KeyEvent) {

    }

    override fun keyPressed(key: KeyEvent) {
        left = key.keyCode == KeyEvent.VK_A
        right = key.keyCode == KeyEvent.VK_D
        forward = key.keyCode == KeyEvent.VK_W
        back = key.keyCode == KeyEvent.VK_S
    }

    override fun keyReleased(key: KeyEvent) {
        if(key.keyCode == KeyEvent.VK_A) left = false
        if(key.keyCode == KeyEvent.VK_D) right = false
        if(key.keyCode == KeyEvent.VK_W) forward = false
        if(key.keyCode == KeyEvent.VK_S) back = false
    }

    override fun draw(g: Graphics) {
        val offsetMaxX = ClientGame.window.width
        val offsetMaxY = ClientGame.window.height
        val offsetMinX = 0
        val offsetMinY = 0
        camX = ClientGame.window.width / 2 // TODO: <users player>.getX() -  Game.window.getWidth() / 2;
        camY = ClientGame.window.height / 2 // TODO: <users player>.getY() -  Game.window.getHeight() / 2;

        if (camX > offsetMaxX) {
            camX = offsetMaxX
        } else if (camX < offsetMinX) {
            camX = offsetMinX
            if (camY > offsetMaxY) {
                camY = offsetMaxY
            }
        } else if (camY < offsetMinY) {
            camY = offsetMinY
        }
        g.translate(-camX, -camY)
        // TODO: Loop throughout world where <User player> is at.
        g.translate(camX, camY)
    }
}
