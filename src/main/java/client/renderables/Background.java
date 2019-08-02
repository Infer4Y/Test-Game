package client.renderables;

import client.Game;
import common.world.World;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Background implements Entity, Drawable {
    private BufferedImage texture;
    private Color c = Color.BLACK;
    private World world;
    private Random r = new Random();
    private ArrayList<Point> points = new ArrayList<>();


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
        points.clear();
        if (world.getTime() >= 1200) {
            c = c.brighter();
        } else if ( world.getTime() <= 1201){
            c = c.darker();
        }
        for (int i = 0; i < 20; i++) {
            int x = r.nextInt(Game.WIDTH-1);
            int y = r.nextInt(Game.HEIGHT/2-1);
            Point p = new Point(x,y);
            points.add(p);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
        g.drawImage(texture, 0,0, Game.WIDTH, Game.HEIGHT, c, null);
        g.setColor(Color.WHITE);
        for (Point p : points) {
            g.drawRect(((int) p.getX()), (int) p.getY(), 1, 1);
        }
    }
}
