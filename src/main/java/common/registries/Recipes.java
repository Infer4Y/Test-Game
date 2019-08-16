package common.registries;

import common.item.ItemStack;
import common.recipes.Recipe;

import java.util.HashMap;

public class Recipes {
    public static final HashMap<String, Recipe> RECIPE_MAP = new HashMap<>();
    public static final Recipe stone_producer = new Recipe("stone_producer", new ItemStack(Items.getItem("planks"), 4), new ItemStack(Items.getItem("stone_producer"), 1));

    public static void init(){
    }

    private static void register(Recipe... recipes){
        for (Recipe recipe: recipes) {
            register(recipe);
        }
    }

    private static void register(Recipe recipe){
        RECIPE_MAP.put(recipe.getName(), recipe);
    }
}
