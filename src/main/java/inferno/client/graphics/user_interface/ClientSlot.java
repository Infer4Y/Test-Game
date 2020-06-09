package inferno.client.graphics.user_interface;

import inferno.client.GameEngine;
import inferno.client.graphics.renderables.TextureHelper;
import inferno.client.graphics.renderables.items.ItemStackRender;
import inferno.client.states.ClientGame;
import inferno.common.containers.Slot;
import inferno.common.registries.Items;
import org.joml.Vector3f;


public class ClientSlot {
    private Slot slot;
    ItemStackRender itemstackRender = new ItemStackRender();
    private float offSet = ((48f-30f)/2f);

    public ClientSlot() {
    }

    public void draw(float x, float y, Vector3f color) {
        TextureHelper.draw(ClientGame.textures.slot, x, y, 48, 48, .9f, color);

        itemstackRender.setItem(slot.getStack().getItem());
        itemstackRender.draw(x+offSet,y+offSet);

        if (slot.getStack().getItem() != Items.getItem("air")) {
            GameEngine.gameFont.drawText((slot.getStack().getAmount()) + "", x + offSet, y + offSet);
        }
    }

    public void draw(float x, float y) {
        TextureHelper.draw(ClientGame.textures.slot, x, y, 48, 48, .9f);

        itemstackRender.setItem(slot.getStack().getItem());
        itemstackRender.draw(x+offSet,y+offSet);

        if (slot.getStack().getItem() != Items.getItem("air")) {
            GameEngine.gameFont.drawText((slot.getStack().getAmount()) + "", x + offSet, y + offSet);
        }
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
