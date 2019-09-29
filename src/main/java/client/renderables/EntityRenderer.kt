package client.renderables

import common.world.Direction
import utils.FileUtils

import javax.imageio.ImageIO
import java.awt.*
import java.awt.image.BufferedImage
import java.io.IOException

class EntityRenderer(val entity: common.entities.Entity, val x: Int, val y: Int) : RenderedEntity(), Drawable {
    var offX: Int = 0
    var offY: Int = 0
    private var texture: BufferedImage? = null
    private val width: Int
    private val height: Int
    private var prevDirection = Direction.LEFT

    init {
        try {
            this.texture = FileUtils.scale1(ImageIO.read(this.javaClass.classLoader.getResource("tex/entities/" + entity.name + ".png")!!), 4.0)
            println(entity.name)
        } catch (e: IOException) {
            try {
                this.texture = FileUtils.scale1(ImageIO.read(this.javaClass.classLoader.getResource("tex/placeholder.png")!!), 4.0)
            } catch (ex: IOException) {
                texture = BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)
                ex.printStackTrace()
            }

            e.printStackTrace()
        } catch (e: NullPointerException) {
            try {
                this.texture = FileUtils.scale1(ImageIO.read(this.javaClass.classLoader.getResource("tex/placeholder.png")!!), 4.0)
            } catch (ex: IOException) {
                texture = BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)
                ex.printStackTrace()
            }

            e.printStackTrace()
        }

        entity.facing = Direction.RIGHT
        this.width = 64
        this.height = 128
        prevDirection = entity.facing
    }

    override fun draw(g: Graphics) {
        g.drawImage(texture, x, y - 64, 64, 128, null)
    }

    override fun tick() {}

    override fun second() {}
}
