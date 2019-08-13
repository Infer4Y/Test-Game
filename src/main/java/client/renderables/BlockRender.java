package client.renderables;

import client.Game;
import client.Sounds;
import client.Textures;
import common.block.Block;
import common.block.BlockAir;
import common.block.BlockLeaf;
import common.item.ItemBlock;
import common.registries.Blocks;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class BlockRender implements Entity, Drawable, MouseListener {
    private BufferedImage texture;
    private Block block;
    private int x, width = 64, y, height = 64;
    private Random r = new Random();

    public BlockRender(Block block, int x, int y){
        this.texture = Game.textures.getTexture4(block.getName());
        this.block = block;
        this.x = x;
        this.y = y;
        this.height = 64;
        this.width = 64;
    }

    @Override
    public void draw(Graphics g) {
        //texture = FileUtils.rotateClockwise(texture);

        g.drawImage(texture, x, y, null);
    }

    @Override
    public void tick() {}

    @Override
    public void second() {}

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && (x <= e.getX() && x+width>= e.getX()) && (y <= e.getY() && y+height>= e.getY())){
            block = Blocks.air;
            texture = Game.textures.getTexture4(block.getName());
            Sounds.playSound("block_break");
        } else if (e.getButton() == MouseEvent.BUTTON3 && (x <= e.getX() && x+width>= e.getX()) && (y <= e.getY() && y+height>= e.getY())){
            if (Game.headsUpDisplay.getSelected().getItemStack().getItem() instanceof ItemBlock) {
                block = ((ItemBlock)Game.headsUpDisplay.getSelected().getItemStack().getItem()).getBlock();
                texture = Game.textures.getTexture4(block.getName());
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width+2, height+2);
    }

    public Block getBlock() {
        return block;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCoords(int i, int i1) {
        this.x = i;
        this.y = i1;
    }
}
