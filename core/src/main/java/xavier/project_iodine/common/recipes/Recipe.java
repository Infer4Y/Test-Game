package xavier.project_iodine.common.recipes;

import xavier.project_iodine.common.item.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
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

    public boolean isCraftable(){
        int amount = 0;
        /*for (int i = 0; i < ingredients.size(); i++) {
            for (int j = 0; j < Game.headsUpDisplay.getSlots().length; j++) {
                if (ingredients.get(i).getItem().equals(Game.headsUpDisplay.getSlots()[j].getItemStack().getItem())) {
                    if (ingredients.get(i).getAmount() <= Game.headsUpDisplay.getSlots()[j].getItemStack().getAmount()) {
                        amount++;
                    }
                }
            }
        }*/
        if (amount >= ingredients.size()){
            return true;
        }

        return false;
    }

    public void craft() {
        for (int i = 0; i < ingredients.size(); i++) {
            /*for (int j = 0; j < Game.headsUpDisplay.getSlots().length; j++) {
                if (ingredients.get(i).getItem().equals(Game.headsUpDisplay.getSlots()[j].getItemStack().getItem())) {
                    if (ingredients.get(i).getAmount() <= Game.headsUpDisplay.getSlots()[j].getItemStack().getAmount()) {
                        Game.headsUpDisplay.getSlots()[j].getItemStack().setAmount(Game.headsUpDisplay.getSlots()[j].getItemStack().getAmount()-ingredients.get(i).getAmount());
                    }
                }
            }
        }
        for (int j = 0; j < result.size(); j++) {
            for (int i = 0; i < Game.headsUpDisplay.getSlots().length; i++) {
                if ((Game.headsUpDisplay.getSlots()[i].getItemStack().getItem())== result.get(j).getItem()) {
                    Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(Game.headsUpDisplay.getSlots()[i].getItemStack().getAmount() + result.get(j).getAmount());
                    break;
                } else if (Game.headsUpDisplay.getSlots()[i].getItemStack().getItem().equals(Items.getItem("air"))) {
                    Game.headsUpDisplay.getSlots()[i].getItemStack().setItem(Items.getItem(result.get(j).getItem().getName()));
                    Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(result.get(j).getAmount());
                    break;
                }
            }*/
        }
    }
}
