package inferno.client.graphics.renderables;

import inferno.client.ClientGame;
import inferno.client.resources.textures.Texture;
import inferno.client.resources.textures.Textures;
import inferno.common.tiles.Tile;
import inferno.utils.Referance;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TileRender implements Drawable {
    private Texture texture;
    private Tile tile;

    public TileRender(){}

    @Override
    public void draw(float x, float y) {
        if (tile != null) {
            texture = ClientGame.textures.getTexture(tile.getName());
            TextureHelper.draw(texture, x, y, Referance.TEXTURE_UNIT, Referance.TEXTURE_UNIT);
        }
        tile = null;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
}
