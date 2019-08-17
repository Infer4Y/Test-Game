package common.registries;

import common.item.ItemStack;
import common.recipes.Recipe;

import java.util.Arrays;
import java.util.HashMap;

public class Recipes {
    public static final HashMap<String, Recipe> RECIPE_MAP = new HashMap<>();
    public static Recipe stone_producer = new Recipe("stone_producer", Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("planks"), 4)}), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("stone_producer"), 1)}));
    public static Recipe wood_producer = new Recipe("wood_producer", Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("planks"), 4),new ItemStack(Items.getItem("log"), 4),new ItemStack(Items.getItem("stone"), 4)}), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("wood_producer"), 1)}));
    public static Recipe planks = new Recipe("planks", Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("log"), 1)}), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("planks"), 4)}));
    public static Recipe sticks = new Recipe("planks", Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("planks"), 1)}), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("sticks"), 2)}));

    public static void init(){
        register(stone_producer, wood_producer, planks, sticks);
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
