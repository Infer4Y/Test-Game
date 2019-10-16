package client.scenes

import java.awt.Canvas
import java.awt.Graphics
import java.awt.event.MouseEvent
import java.awt.event.MouseListener

open class Scene : Canvas(), MouseListener {

    open fun update() {}

    open fun draw(g: Graphics) {}

    override fun mouseClicked(e: MouseEvent) {

    }

    override fun mousePressed(e: MouseEvent) {

    }

    override fun mouseReleased(e: MouseEvent) {

    }

    override fun mouseEntered(e: MouseEvent) {

    }

    override fun mouseExited(e: MouseEvent) {

    }
}