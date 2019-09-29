package common.registries

import common.item.Item
import java.util.HashMap

class ItemRegistry {

    fun init() {
        register(sticks)
        register(coal)
        register(pickaxe)
        register(diamond)
    }



    private fun register(item: Item) {
        ITEM_MAP[item.name] = item
        println(item.name)
    }
    companion object {
        val ITEM_MAP = HashMap<String, Item>()
        @JvmStatic
        val sticks = Item("sticks")
        @JvmStatic
        val coal = Item("coal")
        @JvmStatic
        val pickaxe = Item("pickaxe")
        @JvmStatic
        val diamond = Item("diamond")

        @JvmStatic
        fun getItem(air: String): Item {
            return (ITEM_MAP as java.util.Map<String, Item>).getOrDefault(air, null) as Item
        }
    }
}