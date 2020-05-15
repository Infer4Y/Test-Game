package inferno.client.graphics.renderables;

import inferno.client.ClientGame;
import inferno.common.tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TileRender implements Drawable {
    private BufferedImage texture;
    private Tile tile;
    public int x;
    public int y;

    public TileRender(Tile tile, int x, int y){
        this.texture = ClientGame.textures.getTexture4(tile.getName());
        this.tile = tile;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() { }

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
}
