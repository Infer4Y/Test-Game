package client.renderables;

import client.Game;
import common.block.Block;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BlockRender implements Entity, Drawable {
    private BufferedImage texture;
    private Block block;
    private Block lastBlock;
    public int x;
    public int width = 64;
    public int y;
    public int height = 64;

    public BlockRender(Block block, int x, int y){
        this.texture = Game.textures.getTexture4(block.getName());
        this.block = block;
        this.lastBlock = block;
        this.x = x;
        this.y = y;
        this.height = 64;
        this.width = 64;
    }

    @Override
    public void draw(Graphics g) {
        if (block != lastBlock){
            this.texture = Game.textures.getTexture4(block.getName());
        }
        g.drawImage(texture, x, y, Game.instance);
        lastBlock = block;
    }

    @Override
    public void tick(){
    }

    @Override
    public void second() {}

    public Block getBlock() {
        return block;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCoords(int i, int i1) {
        this.x = i;
        this.y = i1;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
