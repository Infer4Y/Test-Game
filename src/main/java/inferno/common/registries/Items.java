package inferno.common.registries;

import inferno.common.item.*;
import inferno.common.tiles.Tile;
import inferno.common.tiles.TileOre;

import java.util.HashMap;

public class Items {
    public static final HashMap<String, Item> ITEM_MAP = new HashMap<>();
    public static final Item sticks = new ItemMaterial("sticks");
    public static final Item coal = new ItemMaterial("coal");
    public static final Item pickaxe = new ItemPickaxe("pickaxe");
    public static final Item diamond = new ItemMaterial("diamond");

    public static void init(){
        register(sticks);
        register(coal);
        register(pickaxe);
        register(diamond);
        for (Tile b: Tiles.BLOCK_MAP.values()) {
            register(new ItemBlock(b));
            if (b instanceof TileOre){
                if (b.getName().equals(b.getBlockDrop().getName())){
                    register(new ItemIngot(b.getName().replace("ore", "ingot"), ((TileOre) b).getColor().getRGB()));
                }
            }
        }
    }

    public static Item getItem(String name) {
        return ITEM_MAP.getOrDefault(name, null);
    }

    private static void register(Item item){
        ITEM_MAP.put(item.getName(), item);
        System.out.println(item.getName());
    }
}
