package common.item

import java.awt.*

class ItemIngot : ItemColored {
    private var color: Int = 0

    constructor(name: String, color: Int) : super(name) {
        this.color = color
    }

    constructor(name: String) : super(name) {
        this.color = 0xFFF
    }

    override fun onItemUse() {}

    fun getColor(): Color {
        return Color(color)
    }
}
