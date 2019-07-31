package client.renderables;

import client.Game;
import common.world.World;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Background implements Entity, Drawable {
    private BufferedImage texture;
    private Color c = Color.BLACK;
    private boolean f = true;
    private int count;
    private World world;

    public Background(World world) {
        this.world = world;
        try {
            this.texture = ImageIO.read(new File(this.getClass().getClassLoader().getResource("tex/background.png").getFile()));
        } catch (IOException | NullPointerException e) {
            try {
                this.texture = FileUtils.scale1(ImageIO.read(new File(this.getClass().getClassLoader().getResource("tex/placeholder/.png").getFile())), 4.0);
            } catch (IOException ex) {
                this.texture=new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB);
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void tick() {
    }

    @Override
    public void second() {
        if (world.getTime() >= 12) {
            if (c.equals(Color.white)) {
                f = false;
            }
            c = c.brighter();
        } else if ( world.getTime() <= 13){
            if (c.equals(Color.BLACK)) {
                f = true;
            }
            c = c.darker();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
        g.drawImage(texture, 0,0, Game.WIDTH, Game.HEIGHT, c, null);
    }
}
