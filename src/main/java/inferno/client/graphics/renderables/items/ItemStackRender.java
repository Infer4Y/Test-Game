package inferno.client.graphics.renderables.items;


import inferno.client.graphics.renderables.TextureHelper;
import inferno.client.graphics.renderables.entities.EntityRenderer;
import inferno.client.resources.textures.Texture;
import inferno.client.states.ClientGame;
import inferno.common.item.Item;
import inferno.common.registries.Items;
import inferno.common.registries.Tiles;
import inferno.utils.Referance;

public class ItemStackRender extends EntityRenderer {
    private Item item;

    @Override
    public void draw(float x, float y) {
        if (item != null) {
            Texture texture = ClientGame.textures.getTexture(item.getName());
            if (Items.getItem(Tiles.air.getName()) == item) {
                TextureHelper.draw(texture, x, y, 30, 30, 0.1f);
            } else {
                TextureHelper.draw(texture, x, y, 30, 30);
            }
        }
        item = null;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
