package common.recipes

import client.Game
import common.item.ItemBlock
import common.item.ItemStack
import common.registries.Blocks
import common.registries.Items

import java.util.Arrays
import java.util.HashMap

class Recipe(val name: String, val ingredients: List<ItemStack>, val result: List<ItemStack>) {

    val isCraftable: Boolean
        get() = false

    fun craft() {}
}
