package client

import client.scenes.Scene
import common.Game


class ClientGame : Game() {
    var world: ClientWorld = ClientWorld("foo", 0, 0)

    var scene : Scene = Scene()

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

    fun changeScene(target: Scene){
        window.remove(scene)
        scene = target
        window.add(scene)
    }

    /**
     * Updates the world.
     */
    override fun update() {
        world.update()
        scene.update()
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