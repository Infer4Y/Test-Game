package common.registries;

import common.block.Block;

import java.util.HashMap;

public class Blocks {
    public static final HashMap<String, Block> BLOCK_MAP = new HashMap<String, Block>();
    public static Block grass = new Block("grass");
    public static Block dirt = new Block("dirt");
    public static Block stone = new Block("stone");

    public static void init(){
        register(grass, dirt, stone);
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

