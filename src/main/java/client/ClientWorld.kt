package client

import common.world.World

import java.awt.*

class ClientWorld(name: String, x: Int, y: Int) : World(name, x, y) {

    /** Worlds shouldn't be doing any drawing. your Render manager should be  */
    @Deprecated("")
    fun draw(g: Graphics) {}

    override fun update() {}
}
