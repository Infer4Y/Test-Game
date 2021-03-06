package inferno.common.registries;

import inferno.common.tiles.TileOre;
import inferno.common.item.ItemStack;
import inferno.common.recipes.Recipe;

import java.util.Arrays;
import java.util.HashMap;

public class Recipes {
    public static final HashMap<String, Recipe> RECIPE_MAP = new HashMap<>();
    public static Recipe stone_producer = new Recipe("stone_producer", Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("planks"), 4),new ItemStack(Items.getItem("log"), 2),new ItemStack(Items.getItem("stone"), 6)}), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("stone_producer"), 1)}));
    public static Recipe wood_producer = new Recipe("wood_producer", Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("planks"), 4),new ItemStack(Items.getItem("log"), 4),new ItemStack(Items.getItem("stone"), 4)}), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("wood_producer"), 1)}));
    public static Recipe planks = new Recipe("planks", Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("log"), 1)}), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("planks"), 4)}));
    public static Recipe sticks = new Recipe("stick", Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("planks"), 1)}), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("sticks"), 2)}));
    public static Recipe ore_processor;
    public static TileOre[] ores =
            {
                    Tiles.ore_coal,
                    Tiles.ore_copper,
                    Tiles.ore_diamond,
                    Tiles.ore_iron,
                    Tiles.ore_gold,
                    Tiles.ore_tin,
                    Tiles.ore_silver,
                    Tiles.ore_ruby
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
