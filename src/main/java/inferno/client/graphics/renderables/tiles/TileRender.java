package inferno.client.graphics.renderables.tiles;

import inferno.client.graphics.renderables.Drawable;
import inferno.client.graphics.renderables.TextureHelper;
import inferno.client.states.ClientGame;
import inferno.client.resources.textures.Texture;
import inferno.common.tiles.Tile;
import inferno.utils.Referance;

public class TileRender implements Drawable {
    private Texture texture;
    private Tile tile;

    public TileRender(){}

    @Override
    public void draw(float x, float y) {
        if (tile != null) {
            texture = ClientGame.textures.getTexture(tile.getName());
            if (tile.isAir()) {
                TextureHelper.draw(texture, x, y, Referance.TEXTURE_UNIT, Referance.TEXTURE_UNIT, 0.1f);
            } else {
                TextureHelper.draw(texture, x, y, Referance.TEXTURE_UNIT, Referance.TEXTURE_UNIT);
            }
        }
        tile = null;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
}
