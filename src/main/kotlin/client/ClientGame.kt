package client

import client.scenes.SceneMenu
import client.scenes.Scene
import common.Game


class ClientGame : Game() {
    var world: ClientWorld = ClientWorld("foo", 0, 0)


    val WIDTH = 1280
    val HEIGHT = 640

    init {
        window =  Window(WIDTH, HEIGHT, NAME)
    }

    fun createWindow(){
        if (window == null) {
            window = Window(WIDTH, HEIGHT, NAME)
        } else if (!window.isVisible) {
            window.isVisible = true
        } else {
            println("Window has been created already.")
        }
    }

    /**
     * Updates the world.
     */
    override fun update() {
        world.update()
        window.update()
    }

    fun dispose() {
        window.dispose()
    }

    companion object {
        @JvmStatic
        lateinit var window: Window

        @JvmStatic
        lateinit var instance: ClientGame
    }
}