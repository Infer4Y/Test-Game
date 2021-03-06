package inferno.common.recipes;

import inferno.common.containers.Inventory;
import inferno.common.item.ItemStack;

import java.util.List;

public class Recipe {
    private List<ItemStack> ingredients;
    private List<ItemStack> result;
    private String name;

    public Recipe(String name, List<ItemStack> ingredients, List<ItemStack> result) {
        this.ingredients = ingredients;
        this.result = result;
        this.name = name;
    }

    public List<ItemStack> getIngredients() {
        return ingredients;
    }

    public List<ItemStack> getResult() {
        return result;
    }

    public String getName() {
        return name;
    }

    public boolean isCraftable(Inventory inventory){

        return false;
    }

    public void craft() { }
}
