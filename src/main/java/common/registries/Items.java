package common.registries;

import common.block.Block;
import common.item.IItem;
import common.item.Item;
import common.item.ItemBlock;

import java.util.HashMap;

public class Items {
    public static final HashMap<String, Item> ITEM_MAP = new HashMap<>();
    public static final Item sticks = new Item("sticks");
    public static final Item coal = new Item("coal");
    public static final Item pickaxe = new Item("pickaxe");
    public static final Item diamond = new Item("diamond");

    public static void init(){
        register(sticks);
        register(coal);
        register(pickaxe);
        register(diamond);
        for (Block b: Blocks.BLOCK_MAP.values()) {
            register(new ItemBlock(b));
        }
    }

    public static Item getItem(String air) {
        return (Item) ITEM_MAP.getOrDefault(air, null);
    }

    private static void register(Item item){
        ITEM_MAP.put(item.getName(), item);
        System.out.println(item.getName());
    }
}
