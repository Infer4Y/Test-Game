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
    private Hand hand = new Hand();
    private BufferedImage texture;
    private common.entities.Entity entity;
    private int x, width, y, height;
    private Direction prevDirection = Direction.LEFT;
    private World world;
    private float jumpVel = 0.0f;
    private int count;

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
        hand.draw(g,x,y,Game.headsUpDisplay.getSelected().getItemStack(),entity.getFacing());
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
        BlockRender blockLeft=null;
        BlockRender blockRight=null;
        if (x  == 0 || x == 1){
            try {
                blockLeft = world.getMapR()[(int) Math.floor(y / 64)][world.getWidth() - 1];
            } catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
            try {
                blockRight = world.getMapR()[(int) Math.floor(y / 64)][(int) Math.floor(x / 64) + 1];
            } catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }else if ( x == Game.WIDTH-2 || x == Game.WIDTH-1){
            try {
                blockLeft = world.getMapR()[(int) Math.floor(y / 64)][(int) Math.floor((Game.WIDTH - 65) / 65)];
            } catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
            try {
                blockRight = world.getMapR()[(int) Math.floor(y / 64)][0];
            } catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
        } else {

            try {
                blockLeft = world.getMapR()[(int) Math.floor(y / 64)][(((int) Math.floor(x / 64)))];
            } catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
            try {
                blockRight = world.getMapR()[(int) Math.floor(y / 64)][(int) Math.floor(x / 64) + 1];
            } catch (ArrayIndexOutOfBoundsException e){
                blockRight = null;
            }
        }
        if (entity instanceof Player){

            if (this.onGround(nearestBlock) && Game.up){
                setJumping();
            }

            if (Game.right && (blockRight == null || !(blockRight.getBlock().isSolid()))) {
                if (x <= Game.WIDTH-63) {
                    entity.setFacing(Direction.RIGHT);
                    x++;
                } else {
                    x=0;
                }
            } else if (Game.left && (blockLeft == null || !(blockLeft.getBlock().isSolid()))) {
                if (x >= 0) {
                    entity.setFacing(Direction.LEFT);
                    x--;
                } else {
                    x = Game.WIDTH-64;
                }
            }
        }
        if (checkColision(nearestBlock)){
            nearestBlock.getBlock().onBlockCollision(world, this);
        }
        if (checkColision(blockLeft)){
            blockLeft.getBlock().onBlockCollision(world, this);
        }
        if (checkColision(blockRight)){
            blockRight.getBlock().onBlockCollision(world, this);
        }
        if (!(this.onGround(nearestBlock)) && !(this.isJumping())){ y++; } else if (jumpVel != 0) {
            if (this.y > 0) {
                y--;
            }
            jumpVel--;
        }
        world.transition(x - y,y - x);
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
        jumpVel = 68;
    }

    public boolean isJumping(){
        if (jumpVel != 0.0f){
            return true;
        }
        return false;
    }

    private boolean checkColision(BlockRender blockRender){
        if (blockRender != null) {
            if (this.getBounds().intersects(blockRender.getBounds())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColision(EntityRenderer blockRender){
        if (blockRender != null) {
            if (this.getBounds().intersects(blockRender.getBounds())) {
                return true;
            }
        }
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

    public void setJumping(float i) {
        jumpVel = 68 * i;
    }
}
