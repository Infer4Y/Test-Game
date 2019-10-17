package client.threaded

import client.ClientGame
import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferStrategy

//TODO: This should be associated with ClientGame and do the drawing.
// Can be turned into the RenderManager if one is not in use.
class ThreadRenderer : Thread() {

    private fun render() {
        var bufferstrategy : BufferStrategy? = ClientGame.window.bufferStrategy

        if (bufferstrategy == null) {
            ClientGame.window.createBufferStrategy(4)
            return
        }

        var g : Graphics2D = bufferstrategy.drawGraphics as Graphics2D

        bufferstrategy.run {

            g.color = Color.BLACK
            g.fillRect (0, 0, ClientGame.instance.WIDTH, ClientGame.instance.HEIGHT)

            ClientGame.window.draw(g)

            g.dispose ()
            show()
        }

    }

    @Synchronized
    override fun start() {
        super.start()
    }

    override fun run() {
        var bufferstrategy : BufferStrategy? = ClientGame.window.bufferStrategy

        if (bufferstrategy == null) {
            ClientGame.window.createBufferStrategy(4)
            return
        }

        var g : Graphics2D = bufferstrategy.drawGraphics as Graphics2D

        bufferstrategy.run {

            g.color = Color.BLACK
            g.fillRect (0, 0, ClientGame.instance.WIDTH, ClientGame.instance.HEIGHT)

            ClientGame.window.draw(g)

            g.dispose ()
            show()
        }

    }
}
