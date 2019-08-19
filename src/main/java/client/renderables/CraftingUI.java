package client.renderables;

import common.item.ItemStack;
import common.recipes.Recipe;
import common.registries.Items;
import common.registries.Recipes;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class CraftingUI {
    private CraftingSlots[][] craftingSlots = new CraftingSlots[6][3];
    private Recipe[][] recipesFromCraftingSlots = new Recipe[5][3];
    private CraftingSlots[] ingredientSlots;
    private Point loc = new Point(16, 64);

    public CraftingUI(){
        for (int i = 0; i < craftingSlots.length; i++) {
            for (int j = 0; j < craftingSlots[i].length; j++) {
                System.out.println(i+" "+j);
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
        recipesFromCraftingSlots[0][2] = Recipes.stone_producer;
        craftingSlots[1][0].setItemStack(Recipes.wood_producer.getResult().get(0));
        recipesFromCraftingSlots[1][0] = Recipes.wood_producer;
        int ore = 0;
        for (int i = 0; i < craftingSlots.length; i++) {
            for (int j = 0; j < craftingSlots[i].length; j++) {
                try {
                    if ((recipesFromCraftingSlots[i][j].getName().equals("null")) && ore!=Recipes.ore.length) {
                        craftingSlots[i][j].setItemStack(Recipes.ore[ore].getResult().get(0));
                        recipesFromCraftingSlots[i][j] = Recipes.ore[ore];
                        ore++;
                    } else {
                    }
                } catch (ArrayIndexOutOfBoundsException|NullPointerException e){
                    e.printStackTrace();
                }
            }
        }

        ingredientSlots = new CraftingSlots[recipesFromCraftingSlots[0][0].getIngredients().toArray().length];
        for (int i = 0; i < ingredientSlots.length; i++) {
            ingredientSlots[i] = new CraftingSlots();
            ingredientSlots[i].setItemStack(recipesFromCraftingSlots[0][0].getIngredients().get(i));
            ingredientSlots[i].setRectangle(new Rectangle(4 * 36 + 4, (i+1) * 36 + 64, 36, 36));
        }
    }

    public void draw(Graphics2D g){
        g.setColor(new Color(0x9D7F41BF, true));
        g.fillRect(  16-4,  64-4,7 * 36+4, 7 * 36 + 10);
        g.setColor(new Color(0xED646668, true));
        g.fillRoundRect(  18, 6 * 36 + 64,6 * 36 + 28, 38,4,4);
        for (int i = 0; i < craftingSlots.length; i++) {
            for (int j = 0; j < craftingSlots[i].length; j++) {
                try {
                    craftingSlots[i][j].draw((Graphics) g, j * 36 + 16, i * 36 + 64, craftingSlots[i][j].getRectangle().contains(loc));
                    if (craftingSlots[i][j].getRectangle().contains(loc)) {
                        g.setColor(new Color(0x98ACFF));
                        g.setFont(new Font(null, Font.BOLD, 24));
                        g.drawString(craftingSlots[i][j].getItemStack().getItem().getName(),  24, 6 * 36 + 24 + 64);
                    }
                } catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        }
        for (int i = 0; i < ingredientSlots.length; i++) {
            try {
                ingredientSlots[i].draw(g, 3 * 36 + 20, (i+1) * 36 + 66, false);
            } catch (ArrayIndexOutOfBoundsException|NullPointerException e){
                e.printStackTrace();
            }
        }
        g.setColor(new Color(0xED646668, true));
        g.fillRoundRect(  18+(3*36), 62,3 * 36 + 32, 28,2,2);
        g.setColor(new Color(0x98ACFF));
        g.setFont(new Font(null, Font.BOLD, 24));
        g.drawString("Ingredients",  24+(3*36), 64+18);
    }

    public void handleMouseMove(MouseEvent e){
        loc = e.getPoint().getLocation();
        for (int i = 0; i < craftingSlots.length; i++) {
            for (int j = 0; j < craftingSlots[i].length; j++) {
                if (craftingSlots[i][j].getRectangle().contains(loc)){
                    if ((!recipesFromCraftingSlots[i][j].getName().equals("null"))) {
                        try {
                            ingredientSlots = new CraftingSlots[recipesFromCraftingSlots[i][j].getIngredients().toArray().length];
                            for (ItemStack stack: recipesFromCraftingSlots[i][j].getIngredients()) {
                                System.out.println(stack.getItem().getName());
                            }
                            System.out.println(recipesFromCraftingSlots[i][j].getIngredients().toArray().length);
                            for (int l = 0; i < ingredientSlots.length; l++) {
                                ingredientSlots[l] = new CraftingSlots();
                                ingredientSlots[l].setItemStack(recipesFromCraftingSlots[i][j].getIngredients().get(l));
                                ingredientSlots[l].setRectangle(new Rectangle(4 * 36 + 4, i * 36 + 64, 36, 36));
                            }
                        } catch (ArrayIndexOutOfBoundsException|NullPointerException l){
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
                                ingredientSlots = new CraftingSlots[recipesFromCraftingSlots[i][j].getIngredients().toArray().length];
                                for (ItemStack stack: recipesFromCraftingSlots[i][j].getIngredients()) {
                                    System.out.println(stack.getItem().getName());
                                }
                                System.out.println(recipesFromCraftingSlots[i][j].getIngredients().toArray().length-1);
                                for (int l = 0; i < ingredientSlots.length; l++) {
                                    ingredientSlots[l] = new CraftingSlots();
                                    ingredientSlots[l].setItemStack(recipesFromCraftingSlots[i][j].getIngredients().get(l));
                                    ingredientSlots[l].setRectangle(new Rectangle(4 * 36 + 4, i * 36 + 64, 36, 36));
                                }
                            } catch (ArrayIndexOutOfBoundsException|NullPointerException l){
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
                                ingredientSlots = new CraftingSlots[recipesFromCraftingSlots[i][j].getIngredients().toArray().length];
                                for (ItemStack stack: recipesFromCraftingSlots[i][j].getIngredients()) {
                                    System.out.println(stack.getItem().getName());
                                }
                                System.out.println(recipesFromCraftingSlots[i][j].getIngredients().toArray().length-1);
                                for (int l = 0; l < ingredientSlots.length; l++) {
                                    ingredientSlots[l] = new CraftingSlots();
                                    ingredientSlots[l].setItemStack(recipesFromCraftingSlots[i][j].getIngredients().get(l));
                                    ingredientSlots[l].setRectangle(new Rectangle(4 * 36 + 4, i * 36 + 64, 36, 36));
                                }
                            } catch (ArrayIndexOutOfBoundsException|NullPointerException l){
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
