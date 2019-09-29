package common.registries

import common.block.*
import java.util.HashMap

object BlockRegistry {
    @JvmField
    var BLOCK_MAP = HashMap<String, Block>()
    var air = BlockAir("air")
    var grass: Block = BlockGrass("grass_sides")
    var dirt: Block = BlockDirt("dirt")
    var stone: Block = BlockStone("stone")
    var log = BlockLog("log")
    var leaf = BlockLeaf("leaves")
    var planks: Block = BlockPlanks("planks")
    var sapling: Block = BlockSapling("sapling")
    var launcher = BlockLaunchPad("launcher")
    var wood_producer = BlockWoodProducer("wood_producer")
    var crafter = BlockCrafter("crafter")
    var ore_iron = BlockOre("ore_iron", 0xA09090)
    var ore_gold = BlockOre("ore_gold", 0xFFD700)
    var ore_tin = BlockOre("ore_tin", 0xD3C4C4)
    var ore_copper = BlockOre("ore_copper", 0xFF7F50)
    var ore_silver = BlockOre("ore_silver", 0x706868)
    var ore_coal = BlockOre("ore_coal", Items.coal, 0x000)
    var ore_diamond = BlockOre("ore_diamond", Items.diamond, 0x00ffff)
    var ore_ruby = BlockOre("ore_ruby", 0xff2700)
    var ore_producer = BlockOreProducer("ore_producer")
    var stone_producer = BlockStoneProducer("stone_producer")

    @JvmStatic
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
}