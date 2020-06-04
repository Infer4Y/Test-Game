package inferno.client.graphics.user_interface;

import inferno.client.GameEngine;
import inferno.client.graphics.renderables.TextureHelper;
import inferno.client.graphics.renderables.items.ItemStackRender;
import inferno.client.states.ClientGame;
import inferno.common.containers.Slot;


public class ClientSlot {
    private Slot slot;
    ItemStackRender itemstackRender = new ItemStackRender();

    public ClientSlot() {
    }

    public void draw(float x, float y) {
        TextureHelper.draw(ClientGame.textures.slot, x, y, 32f, 32f, .9f);

        itemstackRender.setItem(slot.getStack().getItem());
        itemstackRender.draw(x+1,y+1);

        GameEngine.gameFont.drawText((slot.getStack().getAmount())+"", x + 1f, y + 1f);
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
