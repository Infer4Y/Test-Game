package client.renderables;

import client.Game;
import common.entities.Player;
import common.world.Direction;
import common.world.World;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EntityRenderer implements Entity, Drawable {
    public int offX, offY;
    private BufferedImage texture;
    private common.entities.Entity entity;
    private int x, width, y, height;
    private Direction prevDirection = Direction.LEFT;

    public EntityRenderer(common.entities.Entity entity, int x, int y) {
        try {
            this.texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/entities/" + entity.getName() + ".png")), 4.0);
            System.out.println(entity.getName());
        } catch (IOException | NullPointerException e) {
            try {
                this.texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/placeholder.png")), 4.0);
            } catch (IOException ex) {
                texture=new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB);
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        this.entity = entity;
        entity.setFacing(Direction.RIGHT);
        this.x = x;
        this.y = y;
        this.width = 64;
        this.height = 128;
        prevDirection = entity.getFacing();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(texture, x, y-64,64,128, null);
    }

    @Override
    public void tick() {
    }

    @Override
    public void second() {
    }

    public common.entities.Entity getEntity() {
        return entity;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
