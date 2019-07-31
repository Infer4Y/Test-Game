package common.registries;

import common.item.IItem;

import java.util.HashMap;

public class Items {
    public static final HashMap<String, IItem> ITEM_MAP = new HashMap<String, IItem>();

    public static void init(){}

    private void register(IItem item){
        ITEM_MAP.put(item.getName(), item);
    }
}
