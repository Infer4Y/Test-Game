package common.registries;

import common.block.BlockOre;
import common.item.ItemStack;
import common.recipes.Recipe;

import java.util.Arrays;
import java.util.HashMap;

public class Recipes {
    public static final HashMap<String, Recipe> RECIPE_MAP = new HashMap<>();
    public static Recipe stone_producer = new Recipe("stone_producer", Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("planks"), 4),new ItemStack(Items.getItem("log"), 2),new ItemStack(Items.getItem("stone"), 6)}), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("stone_producer"), 1)}));
    public static Recipe wood_producer = new Recipe("wood_producer", Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("planks"), 4),new ItemStack(Items.getItem("log"), 4),new ItemStack(Items.getItem("stone"), 4)}), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("wood_producer"), 1)}));
    public static Recipe planks = new Recipe("planks", Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("log"), 1)}), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("planks"), 4)}));
    public static Recipe sticks = new Recipe("stick", Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("planks"), 1)}), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("sticks"), 2)}));
    public static Recipe ore_processor;
    public static BlockOre[] ores =
            {
                    Blocks.ore_coal,
                    Blocks.ore_copper,
                    Blocks.ore_diamond,
                    Blocks.ore_iron,
                    Blocks.ore_gold,
                    Blocks.ore_tin,
                    Blocks.ore_silver,
                    Blocks.ore_ruby
            };
    public static Recipe[] ore;

    public static void init(){
        ore = new Recipe[ores.length];

        for (int i = 0; i < ores.length; i++) {
            if (ores[i].getName().equals(ores[i].getBlockDrop().getName())) {
                ore[i] = new Recipe(ores[i].getName(), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem(ores[i].getName()), 1), new ItemStack(Items.getItem("coal"), 1)}), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem(ores[i].getName().replace("ore", "ingot")), 1)}));
            } else{
                ore[i] = new Recipe(ores[i].getName(), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem(ores[i].getName()), 1), new ItemStack(Items.getItem("coal"), 1)}), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem(ores[i].getBlockDrop().getName()), 1)}));
            }
        }
        register(ore);

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
