package client

import client.scenes.Scene
import client.scenes.SceneMenu
import common.Game
import java.awt.Dimension
import java.awt.Graphics2D

import javax.swing.JFrame

class Window(width: Int, height: Int, title: String) : JFrame(title) {

    var scene : Scene = SceneMenu()

    init {
        add(scene)
        addMouseListener(scene)
        scene.isVisible = true
        this.preferredSize = Dimension(width, height)
        this.maximumSize = Dimension(width, height)
        this.minimumSize = Dimension(width, height)
        defaultCloseOperation = EXIT_ON_CLOSE
        isResizable = false
        isVisible = true
        requestFocus()
        //add(game) // TODO
        pack()
        setLocationRelativeTo(null)
    }

    fun update(){
        scene.update()
    }

    fun changeScene(target: Scene){
        remove(scene)
        removeMouseListener(scene)
        scene = target
        scene.isVisible = true
        add(scene)
        addMouseListener(scene)
        requestFocus()
    }

    fun draw(g: Graphics2D) {
        scene.draw(g);
    }
}
