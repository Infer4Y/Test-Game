package common.item

import common.block.Block

class ItemBlock(val block: Block) : Item(block.name) {

    override fun onItemUse() {}
}
