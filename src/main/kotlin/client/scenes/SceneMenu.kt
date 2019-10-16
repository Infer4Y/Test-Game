package client.scenes

import client.ClientGame
import client.ui.Button
import java.awt.Color
import java.awt.Graphics
import java.awt.event.MouseEvent
import kotlin.system.exitProcess

class SceneMenu : Scene() {
    private val start = object : Button(64, 1112, 64, 64, { }) {
        override fun draw(g: Graphics) {
            g.color = Color.green
            g.fillRect(this.x, this.y, this.xBound, this.yBound)
            g.color = Color.white
            g.drawString("Start!", x + (this.xBound - 128 + g.font.size) / 2, y + 16)
        }
    }
    private val exit = object : Button(64, 1112, 256, 64, {
        ClientGame.instance.dispose()
        exitProcess(0)
    }) {
        override fun draw(g: Graphics) {
            g.color = Color.RED
            g.fillRect(this.x, this.y, this.xBound, this.yBound)
            g.color = Color.white
            g.drawString("Exit", x + (this.xBound - 128 + g.font.size) / 2, y + 16)
        }
    }

    override fun update() {
        super.update()
    }

    override fun draw(g: Graphics) {
        start.draw(g)
        exit.draw(g)
    }

    override fun mouseClicked(e: MouseEvent) {
        start.onClick(e.x, e.y)
        exit.onClick(e.x, e.y)
    }
}