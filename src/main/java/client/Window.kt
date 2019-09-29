package client

import common.Game
import java.awt.Dimension

import javax.swing.JFrame

class Window(width: Int, height: Int, title: String, game: Game) : JFrame(title) {
    init {
        this.preferredSize = Dimension(width, height)
        this.maximumSize = Dimension(width, height)
        this.minimumSize = Dimension(width, height)
        defaultCloseOperation = EXIT_ON_CLOSE
        isResizable = false
        isVisible = true
        requestFocus()
        //add(game)
        pack()
        setLocationRelativeTo(null)
    }
}
