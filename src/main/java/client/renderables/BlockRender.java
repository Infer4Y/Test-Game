package client.renderables;

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

public class BlockRender implements Entity, Drawable {
    private Image texture;
    private Block block;
    private int x, x1, y, y1;

    public BlockRender(Block block, int x, int y){
        try {
            this.texture = FileUtils.scale1(ImageIO.read(new File(this.getClass().getClassLoader().getResource("tex/blocks/"+block.getName()+".png").getFile())), 4.0);
            System.out.println(block.getName());
        } catch (IOException | NullPointerException e) {
            this.texture = new BufferedImage(64,64,1);
            e.printStackTrace();
        }
        this.block = block;
        this.x = x;
        this.y = y;
        this.x1 = 0;
        this.y1 = 0;
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
    }
}
