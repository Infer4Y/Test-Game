package client.renderer

import java.awt.Dimension
import javax.swing.JFrame

class Window (name: String?, sizeX: Int, sizeY : Int) : JFrame(name) {
    init {
        val dim = Dimension(sizeX, sizeY)
        this.maximumSize = dim
        this.preferredSize = dim
        this.minimumSize = dim
        this.size = dim
    }
}