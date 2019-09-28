package client

import java.awt.Dimension

import javax.swing.JFrame

class Window(width: Int, height: Int, title: String, game: Game) : JFrame(title) {
    init {
        game.preferredSize = Dimension(width, height)
        game.maximumSize = Dimension(width, height)
        game.minimumSize = Dimension(width, height)
        defaultCloseOperation = EXIT_ON_CLOSE
        isResizable = false
        isVisible = true
        requestFocus()
        add(game)
        pack()
        setLocationRelativeTo(null)
    }
}
