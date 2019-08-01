package client.renderables;

import client.Game;
import common.block.Block;
import common.block.BlockAir;
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
    private int x, x1, y, y1;

    public BlockRender(Block block, int x, int y){
        try {
            this.texture = FileUtils.scale1(ImageIO.read(new File(this.getClass().getClassLoader().getResource("tex/blocks/"+block.getName()+".png").getFile())), 4.0);
        } catch (IOException | NullPointerException e) {
            try {
                this.texture = FileUtils.scale1(ImageIO.read(new File(this.getClass().getClassLoader().getResource("tex/placeholder.png").getFile())), 4.0);
            } catch (IOException ex) {
                texture=new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB);
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        this.block = block;
        this.x = x;
        this.y = y;
        this.x1 = x + 64;
        this.y1 = y + 64;
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
        if (e.getButton() == MouseEvent.BUTTON1 && (x <= e.getX() && x1>= e.getX()) && (y <= e.getY() && y1>= e.getY())){
            block = Blocks.air;
            try {
                this.texture = FileUtils.scale1(ImageIO.read(new File(this.getClass().getClassLoader().getResource("tex/blocks/"+block.getName()+".png").getFile())), 4.0);
            } catch (IOException | NullPointerException e1) {
                try {
                    this.texture = FileUtils.scale1(ImageIO.read(new File(this.getClass().getClassLoader().getResource("tex/placeholder.png").getFile())), 4.0);
                } catch (IOException ex) {
                    texture=new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB);
                    ex.printStackTrace();
                }
                e1.printStackTrace();
            }
        } else if (e.getButton() == MouseEvent.BUTTON3 && (x <= e.getX() && x1>= e.getX()) && (y <= e.getY() && y1>= e.getY())){
            block = Game.currentlySelected.selected;
            try {
                this.texture = FileUtils.scale1(ImageIO.read(new File(this.getClass().getClassLoader().getResource("tex/blocks/"+block.getName()+".png").getFile())), 4.0);
            } catch (IOException | NullPointerException e1) {
                try {
                    this.texture = FileUtils.scale1(ImageIO.read(new File(this.getClass().getClassLoader().getResource("tex/placeholder.png").getFile())), 4.0);
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
}
