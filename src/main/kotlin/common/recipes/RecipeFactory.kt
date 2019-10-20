package common.recipes

import common.item.ItemStack

class RecipeFactory {
    private var ingredients: Array<ItemStack>
        get() {return ingredients}
        set(value) {ingredients = value}

    private var result: Array<ItemStack>
        get() {return result}
        set(value) {result = value}

    fun make (name:String) : Recipe {
        return Recipe(name, ingredients.toList(), result.toList())
    }

    fun clear(){
        result = emptyArray()
        ingredients = emptyArray()
    }
}