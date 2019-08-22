package xavier.project_iodine.common.containers;

import com.badlogic.gdx.utils.Array;

public class Inventory implements IInventory {
    Array<ISlot> slots = new Array<>();

    @Override
    public ISlot getSlot(int id) {
        return slots.get(id);
    }

    @Override
    public void setSlot(ISlot slot, int id) {
        slots.set(id, slot);
    }
}
