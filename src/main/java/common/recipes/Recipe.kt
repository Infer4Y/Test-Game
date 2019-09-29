package common.recipes

import common.item.ItemStack

class Recipe(val name: String, val ingredients: List<ItemStack>, val result: List<ItemStack>) {

    val isCraftable: Boolean
        get() = false

    fun craft() {}
}
