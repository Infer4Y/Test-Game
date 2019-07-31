package client.renderables;

import client.Game;
import common.block.Block;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class BlockRender implements Entity, Drawable {
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
        this.x1 = x;
        this.y1 = y;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(texture, x, y, null);
    }

    @Override
    public void tick() {
    }

    @Override
    public void second() {
        Random r = new Random();
        if (block.getName().equals("air")) {
            texture = FileUtils.rotateClockwise90(texture);
            switch (r.nextInt(3)) {
                case 0:
                    if (!(x > Game.WIDTH - 64)) {
                        x += 64;
                    } else {
                        x = 0;
                    }
                    break;
                case 1:
                    if (!(x < 0)) {
                        x -= 64;
                    } else {
                        x = Game.WIDTH - 64;
                    }
                    break;
                case 2:
                    if (!(y > Game.HEIGHT/2 - 64)) {
                        y += 64;
                    } else {
                        y = 0;
                    }
                    break;
                case 3:
                    if (!(y < 0)) {
                        y -= 64;
                    } else {
                        y = Game.HEIGHT/2 - 64;
                    }
                    break;
                default:
                    x = x1;
                    y = y1;
                    break;
            }
        }
    }
}
