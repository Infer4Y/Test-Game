package common.registries

import common.block.*
import java.util.*

@Deprecated("Completely unnecessary.")
class BlockRegistry {

    fun init() {
        register(grass,
                dirt,
                stone,
                air,
                launcher,
                log,
                leaf,
                planks,
                sapling,
                wood_producer,
                crafter,
                ore_coal,
                ore_copper,
                ore_diamond,
                ore_gold,
                ore_iron,
                ore_ruby,
                ore_silver,
                ore_tin,
                ore_producer,
                stone_producer)
    }

    private fun register(block: Block) {
        BLOCK_MAP[block.name] = block
        println(block.name)
    }

    private fun register(vararg block: Block) {
        for (b in block) {
            BLOCK_MAP[b.name] = b
            println(b.name)
        }
    }

    companion object {
        @JvmField
        var BLOCK_MAP = HashMap<String, Block>()
        @JvmField
        var air = BlockAir("air")
        @JvmField
        var grass: Block = BlockGrass("grass_sides")
        @JvmField
        var dirt: Block = BlockDirt("dirt")
        @JvmField
        var stone: Block = BlockStone("stone")
        @JvmField
        var log = BlockLog("log")
        @JvmField
        var leaf = BlockLeaf("leaves")
        @JvmField
        var planks: Block = BlockPlanks("planks")
        @JvmField
        var sapling: Block = BlockSapling("sapling")
        @JvmField
        var launcher = BlockLaunchPad("launcher")
        @JvmField
        var wood_producer = BlockWoodProducer("wood_producer")
        @JvmField
        var crafter = BlockCrafter("crafter")
        @JvmField
        var ore_iron = BlockOre("ore_iron", 0xA09090)
        @JvmField
        var ore_gold = BlockOre("ore_gold", 0xFFD700)
        @JvmField
        var ore_tin = BlockOre("ore_tin", 0xD3C4C4)
        @JvmField
        var ore_copper = BlockOre("ore_copper", 0xFF7F50)
        @JvmField
        var ore_silver = BlockOre("ore_silver", 0x706868)
        @JvmField
        var ore_coal = BlockOre("ore_coal", ItemRegistry.coal, 0x000)
        @JvmField
        var ore_diamond = BlockOre("ore_diamond", ItemRegistry.diamond, 0x00ffff)
        @JvmField
        var ore_ruby = BlockOre("ore_ruby", 0xff2700)
        @JvmField
        var ore_producer = BlockOreProducer("ore_producer")
        @JvmField
        var stone_producer = BlockStoneProducer("stone_producer")
    }
}