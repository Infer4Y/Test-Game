package common.block

import common.item.Item
import common.registries.ItemRegistry
import java.awt.Color

class BlockOre : BlockColored {
    private var drop: Item? = null
    private var color = 0xFFFFFF

    val blockDrop: Item
        get() = if (drop != null) {
            this.drop!!
        } else ItemRegistry.getItem(this.name)

    constructor(name: String, drop: Item, color: Int) : super(name) {
        this.drop = drop
        this.color = color
    }

    constructor(name: String, drop: Item) : super(name) {
        this.drop = drop
    }

    constructor(name: String, color: Int) : super(name) {
        this.color = color
    }

    constructor(name: String) : super(name) {}

    fun getColor(): Color {
        return Color(color)
    }
}
