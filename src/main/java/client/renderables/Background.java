package client.renderables;

import client.Game;
import common.world.World;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Background implements Entity, Drawable {
    private BufferedImage texture;
    private Color c = Color.BLACK;
    private World world;
    private Star[] stars;
    private Random random=new Random();
    private Rain[] rain;
    private double count;
    private boolean day;
    private int count2;

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

        } catch (IOException | NullPointerException e) {
            try {
                this.texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/placeholder.png")), 4.0);
            } catch (IOException ex) {
                this.texture=new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB);
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        count=-90;
        day = true;
    }

    @Override
    public void tick() {
        for (Star s: stars) {
            s.tick();
        }

        for (Rain raindrops: rain) {
            //raindrops.tick();
        }
    }

    @Override
    public void second() {
        if (count >= -10.d) {
            count = -170;
            day = !day;
        } else {
            count+=360.00000000d/2400.000000000d;
        }
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
            //raindrops.second();
        }
    }

    private  void drawCycle(Graphics g){
        int size = 40;
        if (day) {
            g.setColor(new Color(0xFFE261));
            size = 160;
        } else {
            g.setColor(new Color(0xA6E2DB));
            size = 80;
        }
        g.fillOval(600,40,size,size);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(c);
        graphics2D.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
        graphics2D.setColor(new Color(0x7F3D3DE2, true));
        graphics2D.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
        //graphics2D.drawImage(texture, 0,0, Game.WIDTH, Game.HEIGHT, c, Game.instance);
        graphics2D.setColor(Color.WHITE);
        graphics2D.translate(640,640);
        graphics2D.rotate(Math.toRadians(count));
        drawCycle(graphics2D);
        graphics2D.rotate(-Math.toRadians(count));
        graphics2D.translate(-640,-640);
        if ((world.getTime() >= 1800 && world.getTime() <= 2400) || (world.getTime() >= 0 && world.getTime() <= 700)) {
            for (Star s: stars) {
                s.draw(graphics2D);
            }
        } else {
            for (Rain raindrops: rain) {
                //raindrops.draw(graphics2D);
            }
        }
    }
}
