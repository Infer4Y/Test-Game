package common.world.gen

import common.block.Block
import common.registries.Blocks

import java.util.Random

class Tree {
    private val blocks = arrayOf(Blocks.air, Blocks.leaf, Blocks.log)
    private val struct = arrayOf(arrayOf(intArrayOf(0, 1, 1, 1, 0), intArrayOf(1, 1, 1, 1, 1), intArrayOf(1, 1, 1, 1, 1), intArrayOf(0, 0, 2, 0, 0), intArrayOf(0, 0, 2, 0, 0)), arrayOf(intArrayOf(0, 0, 1, 0, 0), intArrayOf(0, 1, 1, 1, 0), intArrayOf(0, 1, 1, 1, 0), intArrayOf(0, 0, 2, 0, 0), intArrayOf(0, 0, 2, 0, 0)), arrayOf(intArrayOf(0, 0, 1, 0, 0), intArrayOf(0, 1, 1, 1, 0), intArrayOf(1, 1, 1, 1, 1), intArrayOf(0, 0, 2, 0, 0), intArrayOf(0, 0, 2, 0, 0)), arrayOf(intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 2, 0, 0)))

    fun getStruct(): Array<Array<Block>> {
        val structBlock = Array<Array<Block>>(5) { arrayOfNulls(5) }
        val r = Random()
        val c = r.nextInt(struct.size - 1)
        for (i in 0 until struct[c].size) {
            for (j in 0 until struct[c][i].size) {
                print(struct[c][j][i].toString() + " ")
                structBlock[j][i] = blocks[struct[c][j][i]]
            }

            print("\n")
        }
        return structBlock
    }
}
