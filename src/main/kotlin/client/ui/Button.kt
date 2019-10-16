package client.ui

import client.renderables.Drawable
import java.awt.Graphics

open class Button(var x: Int, var xBound: Int, var y: Int, var yBound: Int, private val action: () -> Unit) : Drawable {

    fun onClick(x: Int, y: Int) {
        if (x >= this.x && x <= this.x + this.xBound && y >= this.y && x <= this.y + this.yBound) {
            action.invoke()
        }
    }

    override fun draw(g: Graphics) {}
}