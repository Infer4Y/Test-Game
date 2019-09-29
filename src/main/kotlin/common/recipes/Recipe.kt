package common.recipes

import common.item.ItemStack
import common.registries.RegistryNameable

class Recipe(val name: String, val ingredients: List<ItemStack>, val result: List<ItemStack>): RegistryNameable(name) {

    val isCraftable: Boolean
        get() = false

    fun craft() {}
}
