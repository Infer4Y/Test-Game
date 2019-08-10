package client.renderables;

import common.item.ItemBlock;
import common.item.ItemStack;
import common.world.Direction;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Hand {
    public void draw(Graphics g, int x, int y, ItemStack stack, Direction facing) {
        BufferedImage texture;
        try {
            if (stack.getItem() instanceof ItemBlock) {
                texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/" + stack.getItem().getName() + ".png")), 3.0);
            } else {
                texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/items/" + stack.getItem().getName() + ".png")), 3.0);
            }
        } catch (IOException | NullPointerException e1) {
            try {
                texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/placeholder.png")), 2.0);
            } catch (IOException ex) {
                texture=new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB);
                ex.printStackTrace();
            }
            e1.printStackTrace();
        }
        if (!stack.getItem().getName().equals("air")) {
            if (facing == Direction.RIGHT) {
                g.drawImage(texture, x+32, y-16, null);
            } else {
                texture = FileUtils.horizontalFlip(texture);
                g.drawImage(texture, x-8, y-16,  null);
            }
        }

    }
}
