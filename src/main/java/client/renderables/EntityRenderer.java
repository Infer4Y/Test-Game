package client.renderables;

import client.Game;
import common.entities.Player;
import common.world.Direction;
import common.world.World;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EntityRenderer implements Entity, Drawable {
    private BufferedImage texture;
    private common.entities.Entity entity;
    private int x, width, y, height;
    private Direction prevDirection = Direction.LEFT;
    private World world;
    private float jumpVel = 0.0f;

    public EntityRenderer(common.entities.Entity entity, int x, int y, World world) {
        try {
            this.texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/entities/"+entity.getName()+".png")), 4.0);
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
        this.world = world;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(texture, x, y-64,64,128, null);

    }

    @Override
    public void tick() {
        if (!(prevDirection == entity.getFacing())) {
            if (entity.getFacing() == Direction.LEFT) {
                try {
                    this.texture = FileUtils.scale1(ImageIO.read((this.getClass().getClassLoader().getResource("tex/entities/" + entity.getName() + ".png"))), 4.0);
                } catch (IOException | NullPointerException e) {
                    try {
                        this.texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/placeholder.png")), 4.0);
                    } catch (IOException ex) {
                        texture = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
                        ex.printStackTrace();
                    }
                    e.printStackTrace();
                }
            } else {
                try {
                    this.texture = FileUtils.horizontalFlip(FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/entities/" + entity.getName() + ".png")), 4.0));
                } catch (IOException | NullPointerException e) {
                    try {
                        this.texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/placeholder.png")), 4.0);
                    } catch (IOException ex) {
                        texture = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
                        ex.printStackTrace();
                    }
                    e.printStackTrace();
                }
            }
        }
        prevDirection = entity.getFacing();
        BlockRender nearestBlock = null;
        try {
            nearestBlock = world.getMapR()[(int) Math.floor(y/64)+1][(int) Math.floor(x/64)];
        } catch (ArrayIndexOutOfBoundsException e){
        }
        if (entity instanceof Player){
            if (this.onGround(nearestBlock) && Game.up){
                setJumping();
            }
            if (Game.right) {
                if (x <= Game.WIDTH-63) {
                    entity.setFacing(Direction.RIGHT);
                    x++;
                } else {
                    x=0;
                }
            } else if (Game.left) {
                if (x >= 0) {
                    entity.setFacing(Direction.LEFT);
                    x--;
                } else {
                    x = Game.WIDTH-64;
                }
            }
        }
        if (!(this.onGround(nearestBlock)) && !(this.isJumping())){ y++; } else if (jumpVel != 0) {
            if (this.y > 0) {
                y--;
            }
            jumpVel--;
        }
    }

    private boolean onGround(BlockRender blockRender){
        if (blockRender != null) {
            if ((blockRender.getBlock().isSolid())) {
                return true;
            }
        }
        return false;
    }

    public void setJumping(){
        jumpVel = 64;
    }

    public boolean isJumping(){
        if (jumpVel != 0.0f){
            return true;
        }
        return false;
    }

    private boolean checkColision(BlockRender blockRender){
        return false;
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

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
