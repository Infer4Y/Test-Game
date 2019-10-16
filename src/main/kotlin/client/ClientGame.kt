package client

import client.scenes.SceneMenu
import client.scenes.Scene
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
        scene.isVisible = true
        window.requestFocus()
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
        scene.isVisible = true
        window.add(scene)
        window.addMouseListener(scene)
        window.requestFocus()
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