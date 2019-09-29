package client.renderables

import java.awt.Color
import java.awt.Font
import java.awt.Graphics

//TODO: This shouldn't be an entity.
class FPSViewer : RenderedEntity(), Drawable {
    private var ticks: Int = 0
    private var frames: Int = 0

    private var averageTicks: Int = 0
    private var averageFrames: Int = 0

    override fun draw(g: Graphics) {
        frames++
        if (true) {
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
