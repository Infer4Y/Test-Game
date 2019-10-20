package common.block

import common.item.Item
import common.item.ItemBlock
import common.registries.Registries
import java.awt.Color

class BlockOre : BlockColored {
    private var drop: Item? = null
    private var color = 0xFFFFFF

    val blockDrop: Item
        get() = if (drop != null) {
            this.drop!!
        } else ItemBlock(BlockAir("air"))

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
