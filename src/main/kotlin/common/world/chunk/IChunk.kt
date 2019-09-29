package common.world.chunk

import common.block.Block

interface IChunk {
    val id: Int
    fun getBlock(ID: Int): Block
    fun setBlock(ID: Int)
}
