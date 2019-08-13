package common.registries;

import common.block.*;

import java.util.HashMap;

public class Blocks {
    public static final HashMap<String, Block> BLOCK_MAP = new HashMap<String, Block>();
    public static Block grass = new Block("grass_sides");
    public static Block dirt = new Block("dirt");
    public static Block stone = new Block("stone");
    public static BlockAir air = new BlockAir("air");
    public static BlockLanchPad launcher = new BlockLanchPad("launcher");
    public static BlockLog log = new BlockLog("log");
    public static BlockLeaf leaf = new BlockLeaf("leaves");
    public static Block planks = new Block("planks");
    public static Block sapling = new BlockSapling("sapling");

    public static void init(){
        register(grass, dirt, stone, air, launcher, log, leaf, planks, sapling);
    }

    private static void register(Block block){
        BLOCK_MAP.put(block.getName(), block);
        System.out.println(block.getName());
    }

    private static void register(Block... block){
        for (Block b : block) {
            BLOCK_MAP.put(b.getName(), b);
            System.out.println(b.getName());
        }
    }
}

