package client

import common.Game


class ClientGame : Game{
    var world: ClientWorld = ClientWorld("foo", 0, 0)

    val WIDTH = 640 * 2
    val HEIGHT = 640

    constructor() : super(){
        window = Window(WIDTH, HEIGHT, NAME, this)
    }

    /**
     * Updates the world.
     */
    override fun update() {
        world.update()
    }

    companion object {
        @JvmStatic
        lateinit var window: Window

        @JvmStatic
        lateinit var instance: ClientGame
    }
}