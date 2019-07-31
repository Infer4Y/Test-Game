package client.renderables;

import client.Game;
import common.world.Direction;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EntityRenderer implements Entity, Drawable {
    private BufferedImage texture;
    private common.entities.Entity entity;
    private int x, x1, y, y1;
    private Direction prevDirection = Direction.LEFT;

    public EntityRenderer(common.entities.Entity entity, int x, int y) {
        try {
            this.texture = FileUtils.scale1(ImageIO.read(new File(this.getClass().getClassLoader().getResource("tex/entities/"+entity.getName()+".png").getFile())), 4.0);
            System.out.println(entity.getName());
        } catch (IOException | NullPointerException e) {
            try {
                this.texture = FileUtils.scale1(ImageIO.read(new File(this.getClass().getClassLoader().getResource("tex/placeholder.png").getFile())), 4.0);
            } catch (IOException ex) {
                texture=new BufferedImage(64,64,1);
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        this.entity = entity;
        entity.setFacing(Direction.RIGHT);
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(texture, x, y-64, null);

    }

    @Override
    public void tick() {
        if (!(prevDirection == entity.getFacing())) {
            if (entity.getFacing() == Direction.LEFT) {
                try {
                    this.texture = FileUtils.scale1(ImageIO.read(new File(this.getClass().getClassLoader().getResource("tex/entities/" + entity.getName() + ".png").getFile())), 4.0);
                    System.out.println(entity.getName());
                } catch (IOException | NullPointerException e) {
                    try {
                        this.texture = FileUtils.scale1(ImageIO.read(new File(this.getClass().getClassLoader().getResource("tex/placeholder.png").getFile())), 4.0);
                    } catch (IOException ex) {
                        texture = new BufferedImage(64, 64, 1);
                        ex.printStackTrace();
                    }
                    e.printStackTrace();
                }
            } else {
                try {
                    this.texture = FileUtils.horizontalFlip(FileUtils.scale1(ImageIO.read(new File(this.getClass().getClassLoader().getResource("tex/entities/" + entity.getName() + ".png").getFile())), 4.0));
                    System.out.println(entity.getName());
                } catch (IOException | NullPointerException e) {
                    try {
                        this.texture = FileUtils.scale1(ImageIO.read(new File(this.getClass().getClassLoader().getResource("tex/placeholder.png").getFile())), 4.0);
                    } catch (IOException ex) {
                        texture = new BufferedImage(64, 64, 1);
                        ex.printStackTrace();
                    }
                    e.printStackTrace();
                }
            }
        }
        x++;
        if (x == Game.WIDTH){
            x = 0;
        }
        prevDirection = entity.getFacing();
    }

    @Override
    public void second() {

    }

    public common.entities.Entity getEntity() {
        return entity;
    }

    public void setEntity(common.entities.Entity entity) {
        this.entity = entity;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
