package common.registries

import common.sounds.Sound
import common.block.Block
import common.item.Item
import common.recipes.Recipe

object Registries {
    val REGISTRY_SET = hashSetOf<Registry<out RegistryNameable>>()

    val BLOCKS = Registry(Block::class.java)
    val ITEMS = Registry(Item::class.java)
    val RECIPES = Registry(Recipe::class.java)
    val SOUNDS = Registry(Sound::class.java)

    init {
        REGISTRY_SET.add(BLOCKS)
        REGISTRY_SET.add(ITEMS)
        REGISTRY_SET.add(RECIPES)
    }
}