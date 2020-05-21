package inferno.client.graphics.renderables;

import inferno.client.graphics.renderables.Drawable;
import inferno.client.resources.textures.Texture;
import inferno.client.states.ClientGame;
import inferno.common.entities.Entity;
import inferno.common.world.Direction;
import inferno.utils.Referance;

import java.awt.*;

public class EntityRenderer implements Drawable {
    private Entity entity;
    private Texture texture;

    public EntityRenderer() {
    }

    @Override
    public void draw(float x, float y) {
        if (entity != null) {
            texture = ClientGame.textures.getTexture(entity.getName());
            if (entity.getFacing() == Direction.LEFT) {
                TextureHelper.draw(texture, x-(entity.getBounds().width * Referance.TEXTURE_UNIT)+Referance.TEXTURE_UNIT, y-(entity.getBounds().height * Referance.TEXTURE_UNIT)+Referance.TEXTURE_UNIT, entity.getBounds().width * Referance.TEXTURE_UNIT, entity.getBounds().height * Referance.TEXTURE_UNIT);
            } else {
                TextureHelper.drawFlippedX(texture, x-(entity.getBounds().width * Referance.TEXTURE_UNIT)+Referance.TEXTURE_UNIT, y-(entity.getBounds().height * Referance.TEXTURE_UNIT)+Referance.TEXTURE_UNIT, entity.getBounds().width * Referance.TEXTURE_UNIT, entity.getBounds().height * Referance.TEXTURE_UNIT);
            }
        }
    }


    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
