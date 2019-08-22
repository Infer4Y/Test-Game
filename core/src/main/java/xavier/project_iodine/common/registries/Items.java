package xavier.project_iodine.common.registries;

import xavier.project_iodine.common.block.Block;
import xavier.project_iodine.common.block.BlockOre;
import xavier.project_iodine.common.item.Item;
import xavier.project_iodine.common.item.ItemBlock;
import xavier.project_iodine.common.item.ItemIngot;
import xavier.project_iodine.utils.Logger;

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
            if (b instanceof BlockOre){
                if (b.getName().equals(b.getBlockDrop().getName())){
                    register(new ItemIngot(b.getName().replace("ore", "ingot"), ((BlockOre) b).getColor()));
                }
            }
        }
    }

    public static Item getItem(String air) {
        return (Item) ITEM_MAP.getOrDefault(air, null);
    }

    private static void register(Item item){
        ITEM_MAP.put(item.getName(), item);
        Logger.log(Logger.Type.REGISTRY, "[Registry:Items] %s has been registered.".replace("%s", item.getName()));
    }
}
