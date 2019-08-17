package client.renderables;

import common.recipes.Recipe;
import common.registries.Recipes;

import java.awt.*;
import java.awt.event.MouseEvent;

public class CraftingUI {
    private CraftingSlots[][] craftingSlots = new CraftingSlots[5][3];
    private Point loc = new Point(320, 64);

    public CraftingUI(){
        for (int i = 0; i < craftingSlots.length; i++) {
            for (int j = 0; j < craftingSlots[i].length; j++) {
                craftingSlots[i][j] = new CraftingSlots();
            }
        }
        craftingSlots[0][0].setItemStack(Recipes.planks.getResult().get(0));
        craftingSlots[0][1].setItemStack(Recipes.sticks.getResult().get(0));
        craftingSlots[0][0].setItemStack(Recipes.planks.getResult().get(0));
    }

    public void draw(Graphics2D g){
        for (int i = 0; i < craftingSlots.length; i++) {
            for (int j = 0; j < craftingSlots[i].length; j++) {
                try {
                    craftingSlots[i][j].draw((Graphics) g, j * 36 + 16, i * 36 + 64, (new Rectangle(j * 36 + 16, i * 36 + 64, 36, 36).contains(loc)));
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
    }

    public void open(){}

    public void close(){}
}
