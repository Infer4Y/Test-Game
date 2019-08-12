package client.renderables;

import client.Game;
import client.Textures;
import common.item.ItemBlock;
import common.item.ItemStack;
import common.world.Direction;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Hand {
    BufferedImage texture;
    ItemStack lastStack;
    public void draw(Graphics g, int x, int y, ItemStack stack, Direction facing) {
        if (lastStack == null) {
            texture = FileUtils.rotateClockwise(Game.textures.getTexture3(stack.getItem().getName()));
        } else if (!lastStack.getItem().getName().equals(stack.getItem().getName())) {
            texture = FileUtils.rotateClockwise(Game.textures.getTexture3(stack.getItem().getName()));
        } else {
            texture = FileUtils.rotateClockwise(texture);
        }
        if (!stack.getItem().getName().equals("air")) {
            if (facing == Direction.RIGHT) {
                g.drawImage(texture, x+32, y-16, null);
            } else {
                texture = FileUtils.horizontalFlip(texture);
                g.drawImage(texture, x-8, y-16,  null);
            }
        }
        lastStack = stack;
    }
}
