package inferno.client.graphics.user_interface;

import inferno.client.GameEngine;
import inferno.client.graphics.renderables.Drawable;
import inferno.common.containers.Slot;
import inferno.utils.Referance;
import org.joml.Vector3f;

import java.util.ArrayList;

public class HeadsUpDisplay implements Drawable {

    private ArrayList<Slot> slots = new ArrayList<>();

    private ClientSlot slotRenderer = new ClientSlot();

    public HeadsUpDisplay() {}

    @Override
    public void draw(float x, float y) {
        float spacing = 4f;
        float totalWidth = (spacing+48f)*slots.size();
        float start = (Referance.WIDTH-totalWidth)/2f;

        float index = 0f;

        for (Slot slot: slots) {
            slotRenderer.setSlot(slot);
            if (index == GameEngine.slotSelected) {
                slotRenderer.draw(start + spacing + (index * 48f), 8f, new Vector3f(1,0,0));
            } else {
                slotRenderer.draw(start + spacing + (index * 48f), 8f);
            }
            index += 1f;
        }
        updateSlots();
    }

    private void updateSlots(){
        slots.clear();
        for (int i = 0; i < GameEngine.userInstance.getInventory().getSize(); i++) {
            slots.add(GameEngine.userInstance.getInventory().getSlotFromID(i));
        }
    }
}
