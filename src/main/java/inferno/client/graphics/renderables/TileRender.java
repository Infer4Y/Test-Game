package inferno.client.graphics.renderables;

import inferno.client.ClientGame;
import inferno.client.resources.textures.Texture;
import inferno.common.tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TileRender implements Drawable {
    private Texture texture;
    private Tile tile;

    public TileRender(){}

    @Override
    public void draw(float x, float y) { }
}
