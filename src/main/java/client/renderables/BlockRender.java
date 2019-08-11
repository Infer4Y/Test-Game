package client.renderables;

import client.Game;
import client.Textures;
import common.block.Block;
import common.block.BlockAir;
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

    public BlockRender(Block block, int x, int y){
        this.texture = Textures.getTexture4(block.getName());
        this.block = block;
        this.x = x;
        this.y = y;
        this.height = 64;
        this.width = 64;
    }

    @Override
    public void draw(Graphics g) {
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
            try {
                this.texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/"+block.getName()+".png")), 4.0);
            } catch (IOException | NullPointerException e1) {
                try {
                    this.texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/placeholder.png")), 4.0);
                } catch (IOException ex) {
                    texture=new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB);
                    ex.printStackTrace();
                }
                e1.printStackTrace();
            }
        } else if (e.getButton() == MouseEvent.BUTTON3 && (x <= e.getX() && x+width>= e.getX()) && (y <= e.getY() && y+height>= e.getY())){
            if (Game.headsUpDisplay.getSelected().getItemStack().getItem() instanceof ItemBlock) {
                block = ((ItemBlock)Game.headsUpDisplay.getSelected().getItemStack().getItem()).getBlock();
            }
            try {
                this.texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/"+block.getName()+".png")), 4.0);
            } catch (IOException | NullPointerException e1) {
                try {
                    this.texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/placeholder.png")), 4.0);
                } catch (IOException ex) {
                    texture=new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB);
                    ex.printStackTrace();
                }
                e1.printStackTrace();
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
