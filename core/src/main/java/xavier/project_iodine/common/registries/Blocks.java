package xavier.project_iodine.common.registries;

import xavier.project_iodine.common.block.*;
import xavier.project_iodine.utils.Logger;

import java.util.HashMap;

public class Blocks {
    public static final HashMap<String, Block> BLOCK_MAP = new HashMap<String, Block>();
    public static Block grass = new Block("grass_sides");
    public static Block dirt = new Block("dirt");
    public static Block stone = new Block("stone");
    public static BlockAir air = new BlockAir("air");
    public static BlockLaunchPad launcher = new BlockLaunchPad("launcher");
    public static BlockLog log = new BlockLog("log");
    public static BlockLeaf leaf = new BlockLeaf("leaves");
    public static Block planks = new Block("planks");
    public static Block sapling = new BlockSapling("sapling");
    public static BlockWoodProducer wood_producer = new BlockWoodProducer("wood_producer");
    public static BlockCrafter crafter = new BlockCrafter("crafter");
    public static BlockOre ore_iron = new BlockOre("ore_iron", 0xA09090ff);
    public static BlockOre ore_gold = new BlockOre("ore_gold", 0xFFD700ff);
    public static BlockOre ore_tin = new BlockOre("ore_tin", 0xD3C4C4ff);
    public static BlockOre ore_copper = new BlockOre("ore_copper", 0xFF7F50ff);
    public static BlockOre ore_silver = new BlockOre("ore_silver", 0x706868ff);
    public static BlockOre ore_coal = new BlockOre("ore_coal", Items.coal, 0x000000ff);
    public static BlockOre ore_diamond = new BlockOre("ore_diamond",Items.diamond, 0x00ffffff);
    public static BlockOre ore_ruby = new BlockOre("ore_ruby", 0xff2700ff);
    public static BlockOreProducer ore_producer = new BlockOreProducer("ore_producer");
    public static BlockStoneProducer stone_producer = new BlockStoneProducer("stone_producer");
    public static BlockColored plastic = new BlockColored("plastic");
    public static BlockColored plastic_smooth = new BlockColored("plastic_smooth");

    public static void init(){
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
                stone_producer);
        register(plastic.getRegistyInstance(plastic));
        register(plastic_smooth.getRegistyInstance(plastic_smooth));
    }

    private static void register(Block block){
        BLOCK_MAP.put(block.getName(), block);
        Logger.log(Logger.Type.REGISTRY, "[Registry:Blocks] %s has been registered.".replace("%s", block.getName()));
    }

    private static void register(Block... block){
        for (Block b : block) {
            register(b);
        }
    }

    public static Block getBlock(String name){
        return BLOCK_MAP.getOrDefault(name, air);
    }
}

