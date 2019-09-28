package client.handlers

import client.renderables.BlockRender
import common.block.Block
import common.world.World

class BlockHandler {

    fun handleBlockRenderer(world: World): BlockRender? {
        return null
    }

    companion object {

        @JvmStatic
        fun handleBlockRenderer(block: Block, x: Int, y: Int): BlockRender {
            return BlockRender(block, x, y)
        }
    }

}
