package client.renderables

import client.Game
import java.awt.Color
import java.awt.Font
import java.awt.Graphics

class FPSViewer : Entity(), Drawable {
    private var ticks: Int = 0
    private var frames: Int = 0

    private var averageTicks: Int = 0
    private var averageFrames: Int = 0

    override fun draw(g: Graphics) {
        frames++
        if (Game.f3) {
            g.color = Color.GREEN
            g.font = Font(null, 0, 24)
            g.drawString("FPS: $averageFrames Ticks: $averageTicks", 1280 - 14 * (5 + 2 + 6 + 2), 24)
        }
    }

    override fun tick() {
        ticks++
    }

    override fun second() {
        averageFrames = frames
        averageTicks = ticks
        frames = 0
        ticks = 0
    }
}
