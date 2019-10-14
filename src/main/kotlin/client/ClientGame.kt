package client

import client.scenes.*
import common.Game


class ClientGame : Game() {
    var world: ClientWorld = ClientWorld("foo", 0, 0)

    var scene : Scene = SceneMenu()

    val WIDTH = 1280
    val HEIGHT = 640

    init {
        window =  Window(WIDTH, HEIGHT, NAME)
        window.add(scene)
        window.addMouseListener(scene)
    }

    fun createWindow(){
        if (window == null) {
            window = Window(WIDTH, HEIGHT, NAME)
            window.add(scene)
            window.addMouseListener(scene)
        } else if (!window.isVisible) {
            window.isVisible = true
        } else {
            println("Window has been created already.")
        }
    }

    fun changeScene(target: Scene){
        window.remove(scene)
        window.removeMouseListener(scene)
        scene = target
        window.add(scene)
        window.addMouseListener(scene)
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