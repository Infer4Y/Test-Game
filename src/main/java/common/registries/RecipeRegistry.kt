package common.registries

import common.item.ItemStack
import common.recipes.Recipe
import java.util.*

class RecipeRegistry {



    fun init() {
        for (i in ores.indices) {
            if (ores[i].name == ores[i].blockDrop.name) {
                ore[i] = Recipe(ores[i].name, mutableListOf(ItemStack(ItemRegistry.getItem(ores[i].name), 1), ItemStack(ItemRegistry.getItem("coal"), 1)), mutableListOf(ItemStack(ItemRegistry.getItem(ores[i].name.replace("ore", "ingot")), 1)))
            } else {
                ore[i] = Recipe(ores[i].name, mutableListOf(ItemStack(ItemRegistry.getItem(ores[i].name), 1), ItemStack(ItemRegistry.getItem("coal"), 1)), mutableListOf(ItemStack(ItemRegistry.getItem(ores[i].blockDrop.name), 1)))
            }
        }
        register(ore)

        register(stone_producer)
        register(wood_producer)
        register(planks)
        register(sticks)
    }

    private fun register(recipes: Array<Recipe?>) {
        for (recipe in recipes) {
            if (recipe != null) {
                register(recipe)
            } else {
                //Logger
            }
        }
    }

    private fun register(recipe: Recipe) {
        if (recipe != null) {
            RECIPE_MAP[recipe.name] = recipe
        }else {
            //Logger
        }
    }

    companion object{
        val RECIPE_MAP = HashMap<String, Recipe?>()
        var stone_producer = Recipe("stone_producer", Arrays.asList(ItemStack(ItemRegistry.getItem("planks"), 4), ItemStack(ItemRegistry.getItem("log"), 2), ItemStack(ItemRegistry.getItem("stone"), 6)), mutableListOf(ItemStack(ItemRegistry.getItem("stone_producer"), 1)))
        var wood_producer = Recipe("wood_producer", Arrays.asList(ItemStack(ItemRegistry.getItem("planks"), 4), ItemStack(ItemRegistry.getItem("log"), 4), ItemStack(ItemRegistry.getItem("stone"), 4)), mutableListOf(ItemStack(ItemRegistry.getItem("wood_producer"), 1)))
        var planks = Recipe("planks", mutableListOf(ItemStack(ItemRegistry.getItem("log"), 1)), mutableListOf(ItemStack(ItemRegistry.getItem("planks"), 4)))
        var sticks = Recipe("stick", mutableListOf(ItemStack(ItemRegistry.getItem("planks"), 1)), mutableListOf(ItemStack(ItemRegistry.getItem("sticks"), 2)))
        var ore_processor: Recipe? = null
        var ores = arrayOf(BlockRegistry.ore_coal,
                BlockRegistry.ore_copper,
                BlockRegistry.ore_diamond,
                BlockRegistry.ore_iron,
                BlockRegistry.ore_gold,
                BlockRegistry.ore_tin,
                BlockRegistry.ore_silver,
                BlockRegistry.ore_ruby)
        var ore: Array<Recipe?> = arrayOfNulls(ores.size)
    }
}