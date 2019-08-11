package client.renderables;

import client.Game;
import common.world.World;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Background implements Entity, Drawable {
    private BufferedImage texture;
    private BufferedImage texture1;
    private Color c = Color.BLACK;
    private World world;
    private Star[] stars;
    private Random random=new Random();
    private Rain[] rain;
    private int count;

    public Background(World world) {
        this.world = world;
        int allowedStars = (int) (random.nextInt(10)+20);
        this.stars = new Star[allowedStars];
        for (int i = 0; i < allowedStars; i++) {
            stars[i] = new Star(random.nextInt(Game.WIDTH),random.nextInt(Game.HEIGHT/2), random.nextInt(6)+1, random.nextInt(10));
        }
        int allowedRainDrops = (int) (random.nextInt(10)+40);
        this.rain = new Rain[allowedRainDrops];
        for (int i = 0; i < allowedRainDrops; i++) {
            rain[i] = new Rain(random.nextInt(Game.WIDTH),random.nextInt(Game.HEIGHT/2), random.nextInt(6)+1);
        }
        try {
            this.texture = ImageIO.read(this.getClass().getClassLoader().getResource("tex/background.png"));
            this.texture1 = FileUtils.verticalFlip(FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/sunmoon.png")),1.5));
        } catch (IOException | NullPointerException e) {
            try {
                this.texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/placeholder.png")), 4.0);
            } catch (IOException ex) {
                this.texture=new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB);
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void tick() {
        for (Star s: stars) {
            s.tick();
        }

        for (Rain raindrops: rain) {
            raindrops.tick();
        }
    }

    @Override
    public void second() {
        if (world.getTime() >= 600 && world.getTime() <= 1200) {
            c = c.brighter();
        } else if (world.getTime() == 1200){
            c = Color.white;
        }else if (world.getTime() <= 1201 && world.getTime() <= 1799){
            c = c.darker();
        } else if ( world.getTime() <= 1800){
            c = Color.BLACK;
        }
        for (Star s : stars) {
            s.second();
        }
        for (Rain raindrops: rain) {
            raindrops.second();
        }
        if (count == 200){
            texture1 = FileUtils.rotateClockwise(texture1);

            count=0;
        } else {
            count++;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
        g.drawImage(texture, 0,0, Game.WIDTH, Game.HEIGHT, c, Game.instance);
        g.drawImage(texture1, 0-texture1.getWidth()/6,0-texture1.getHeight()/8, c, Game.instance);
        g.setColor(Color.WHITE);
        if ((world.getTime() >= 1800 && world.getTime() <= 2400) || (world.getTime() >= 0 && world.getTime() <= 700)) {
            for (Star s: stars) {
                s.draw(g);
            }
        } else {
            for (Rain raindrops: rain) {
                raindrops.draw(g);
            }
        }
    }
}
