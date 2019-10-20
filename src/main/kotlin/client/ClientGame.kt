package client

import common.Game


class ClientGame : Game() {
    var world: ClientWorld = ClientWorld("foo", 0, 0)

    val WIDTH = 1280
    val HEIGHT = 640

    override fun update() {
        world.update()
    }

    companion object {
        @JvmStatic
        lateinit var instance: ClientGame
    }
}