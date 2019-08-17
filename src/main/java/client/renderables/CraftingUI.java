package client.renderables;

import common.recipes.Recipe;
import common.registries.Recipes;

import java.awt.*;
import java.awt.event.MouseEvent;

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
                recipesFromCraftingSlots[i][j] = new Recipe(null, null, null);
            }
        }
        craftingSlots[0][0].setItemStack(Recipes.planks.getResult().get(0));
        recipesFromCraftingSlots[0][0] = Recipes.planks;
        craftingSlots[0][1].setItemStack(Recipes.sticks.getResult().get(0));
        recipesFromCraftingSlots[0][1] = Recipes.sticks;
        craftingSlots[0][2].setItemStack(Recipes.stone_producer.getResult().get(0));
        recipesFromCraftingSlots[0][1] = Recipes.sticks;
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
    }

    public void handleMouseMove(MouseEvent e){
        loc = e.getPoint().getLocation();
    }

    public void handleMouseClick(MouseEvent e){
        loc = e.getPoint().getLocation();
        if (e.getButton() == MouseEvent.BUTTON1) {
            for (int i = 0; i < craftingSlots.length; i++) {
                for (int j = 0; j < craftingSlots[i].length; j++) {
                    if (craftingSlots[i][j].getRectangle().contains(loc)){
                        if (recipesFromCraftingSlots[i][j] != null) {
                            if (recipesFromCraftingSlots[i][j].isCraftable()) {
                                recipesFromCraftingSlots[i][j].craft();
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
