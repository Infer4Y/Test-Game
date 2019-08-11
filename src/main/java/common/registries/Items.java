package common.registries;

import common.block.Block;
import common.item.IItem;
import common.item.Item;
import common.item.ItemBlock;

import java.util.HashMap;

public class Items {
    public static final HashMap<String, Item> ITEM_MAP = new HashMap<>();

    public static void init(){
        for (Block b: Blocks.BLOCK_MAP.values()) {
            register(new ItemBlock(b));
        }
    }

    public static Item getItem(String air) {
        return (Item) ITEM_MAP.getOrDefault(air, null);
    }

    private static void register(Item item){
        ITEM_MAP.put(item.getName(), item);
    }
}
