package common.item

import common.block.Block

class ItemBlock(val block: Block) : Item(block.name) {

    override fun onItemUse() {
        //TODO: On item use add block to world and decress item stack.
    }
}
