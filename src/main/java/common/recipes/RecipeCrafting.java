package common.recipes;

import common.item.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RecipeCrafting {
    private List<ItemStack> ingredients;
    private List<ItemStack> result;

    public RecipeCrafting(List<ItemStack> ingredients, List<ItemStack> result) {
        this.ingredients = ingredients;
        this.result = result;
    }


}
