package client.renderables

import client.Game
import common.block.Block

import java.awt.*
import java.awt.image.BufferedImage

class BlockRender(var block: Block?, var x: Int, var y: Int) : Entity(), Drawable {

    private var texture: BufferedImage? = null
    private var lastBlock: Block? = null
    var width = 64
    var height = 64

    init {
        this.texture = Game.textures.getTexture4(block?.name)
        this.lastBlock = block
        this.height = 64
        this.width = 64
    }

    override fun draw(g: Graphics) {
        if (block !== lastBlock) {
            this.texture = Game.textures.getTexture4(block?.name)
        }
        g.drawImage(texture, x, y, Game.instance)
        lastBlock = block
    }

    override fun tick() {}

    override fun second() {}

    fun setCoords(i: Int, i1: Int) {
        this.x = i
        this.y = i1
    }
}
