package client.renderables;

import common.item.ItemStack;
import common.recipes.Recipe;
import common.registries.Items;
import common.registries.Recipes;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class CraftingUI {
    private CraftingSlots[][] craftingSlots = new CraftingSlots[5][3];
    private Recipe[][] recipesFromCraftingSlots = new Recipe[5][3];
    private CraftingSlots[] ingredientSlots;
    private Point loc = new Point(320, 64);

    public CraftingUI(){
        for (int i = 0; i < craftingSlots.length; i++) {
            for (int j = 0; j < craftingSlots[i].length; j++) {
                craftingSlots[i][j] = new CraftingSlots();
                craftingSlots[i][j].setRectangle(new Rectangle(j * 36 + 16, i * 36 + 64, 36, 36));
            }
        }
        for (int i = 0; i < recipesFromCraftingSlots.length; i++) {
            for (int j = 0; j < recipesFromCraftingSlots[i].length; j++) {
                recipesFromCraftingSlots[i][j] = new Recipe("null", Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("air"), 0)}), Arrays.asList(new ItemStack[]{new ItemStack(Items.getItem("air"), 0)}));
            }
        }
        craftingSlots[0][0].setItemStack(Recipes.planks.getResult().get(0));
        recipesFromCraftingSlots[0][0] = Recipes.planks;
        craftingSlots[0][1].setItemStack(Recipes.sticks.getResult().get(0));
        recipesFromCraftingSlots[0][1] = Recipes.sticks;
        craftingSlots[0][2].setItemStack(Recipes.stone_producer.getResult().get(0));
        recipesFromCraftingSlots[0][1] = Recipes.sticks;
        ingredientSlots = new CraftingSlots[recipesFromCraftingSlots[0][0].getIngredients().size()];
        for (int i = 0; i < ingredientSlots.length; i++) {
            ingredientSlots[i] = new CraftingSlots();
            ingredientSlots[i].setItemStack(recipesFromCraftingSlots[0][0].getIngredients().get(i));
            ingredientSlots[i].setRectangle(new Rectangle(4 * 36 + 4, i * 36 + 64, 36, 36));
        }
    }

    public void draw(Graphics2D g){
        for (int i = 0; i < craftingSlots.length; i++) {
            for (int j = 0; j < craftingSlots[i].length; j++) {
                try {
                    craftingSlots[i][j].draw((Graphics) g, j * 36 + 16, i * 36 + 64, craftingSlots[i][j].getRectangle().contains(loc));
                } catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        }
        for (int i = 0; i < ingredientSlots.length; i++) {
            try {
                ingredientSlots[i].draw(g, ingredientSlots[i].getRectangle().x,ingredientSlots[i].getRectangle().y, false);
            } catch (NullPointerException e){
                e.printStackTrace();
            }
        }
    }

    public void handleMouseMove(MouseEvent e){
        loc = e.getPoint().getLocation();
        for (int i = 0; i < craftingSlots.length; i++) {
            for (int j = 0; j < craftingSlots[i].length; j++) {
                if (craftingSlots[i][j].getRectangle().contains(loc)){
                    if ((!recipesFromCraftingSlots[i][j].getName().equals("null"))) {
                        try {
                            ingredientSlots = new CraftingSlots[recipesFromCraftingSlots[i][j].getIngredients().size() + 1];
                            for (int l = 0; i < ingredientSlots.length; l++) {
                                ingredientSlots[l] = new CraftingSlots();
                                ingredientSlots[l].setItemStack(recipesFromCraftingSlots[i][j].getIngredients().get(l));
                                ingredientSlots[l].setRectangle(new Rectangle(4 * 36 + 4, i * 36 + 64, 36, 36));
                            }
                        } catch (NullPointerException l){
                            l.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void handleMouseClick(MouseEvent e){
        loc = e.getPoint().getLocation();
        if (e.getButton() == MouseEvent.BUTTON1 && !e.isShiftDown()) {
            for (int i = 0; i < craftingSlots.length; i++) {
                for (int j = 0; j < craftingSlots[i].length; j++) {
                    if (craftingSlots[i][j].getRectangle().contains(loc)){
                        if ((!recipesFromCraftingSlots[i][j].getName().equals("null"))) {
                            if (recipesFromCraftingSlots[i][j].isCraftable()) {
                                recipesFromCraftingSlots[i][j].craft();
                            }
                            try {
                                ingredientSlots = new CraftingSlots[recipesFromCraftingSlots[i][j].getIngredients().size() + 1];
                                for (int l = 0; i < ingredientSlots.length; l++) {
                                    ingredientSlots[l] = new CraftingSlots();
                                    ingredientSlots[l].setItemStack(recipesFromCraftingSlots[i][j].getIngredients().get(l));
                                    ingredientSlots[l].setRectangle(new Rectangle(4 * 36 + 4, i * 36 + 64, 36, 36));
                                }
                            } catch (NullPointerException l){
                                l.printStackTrace();
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < craftingSlots.length; i++) {
                for (int j = 0; j < craftingSlots[i].length; j++) {
                    if (craftingSlots[i][j].getRectangle().contains(loc)){
                        if (!recipesFromCraftingSlots[i][j].getName().equals("null")) {
                            try {
                                ingredientSlots = new CraftingSlots[recipesFromCraftingSlots[i][j].getIngredients().size() + 1];
                                for (int l = 0; i < ingredientSlots.length; l++) {
                                    ingredientSlots[l] = new CraftingSlots();
                                    ingredientSlots[l].setItemStack(recipesFromCraftingSlots[i][j].getIngredients().get(l));
                                    ingredientSlots[l].setRectangle(new Rectangle(4 * 36 + 4, i * 36 + 64, 36, 36));
                                }
                            } catch (NullPointerException l){
                                l.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

    }

    public void open(){}

    public void close(){}
}
