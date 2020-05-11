package inferno.common.registries;

import inferno.common.tiles.*;

import java.util.HashMap;

public class Tiles {
    public static final HashMap<String, Tile> BLOCK_MAP = new HashMap<String, Tile>();
    public static Tile grass = new Tile("grass_sides");
    public static Tile dirt = new Tile("dirt");
    public static Tile stone = new Tile("stone");
    public static TileAir air = new TileAir("air");
    public static TileLaunchPad launcher = new TileLaunchPad("launcher");
    public static TileLog log = new TileLog("log");
    public static TileLeaf leaf = new TileLeaf("leaves");
    public static Tile planks = new Tile("planks");
    public static Tile sapling = new TileSapling("sapling");
    public static TileWoodProducer wood_producer = new TileWoodProducer("wood_producer");
    public static TileCrafter crafter = new TileCrafter("crafter");
    public static TileOre ore_iron = new TileOre("ore_iron", 0xA09090);
    public static TileOre ore_gold = new TileOre("ore_gold", 0xFFD700);
    public static TileOre ore_tin = new TileOre("ore_tin", 0xD3C4C4);
    public static TileOre ore_copper = new TileOre("ore_copper", 0xFF7F50);
    public static TileOre ore_silver = new TileOre("ore_silver", 0x706868);
    public static TileOre ore_coal = new TileOre("ore_coal", Items.coal, 0x000);
    public static TileOre ore_diamond = new TileOre("ore_diamond", Items.diamond, 0x00ffff);
    public static TileOre ore_ruby = new TileOre("ore_ruby", 0xff2700);
    public static TileOreProducer ore_producer = new TileOreProducer("ore_producer");
    public static TileStoneProducer stone_producer = new TileStoneProducer("stone_producer");

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
    }

    private static void register(Tile tile){
        BLOCK_MAP.put(tile.getName(), tile);
        System.out.println(tile.getName());
    }

    private static void register(Tile... tile){
        for (Tile b : tile) {
            BLOCK_MAP.put(b.getName(), b);
            System.out.println(b.getName());
        }
    }
}

