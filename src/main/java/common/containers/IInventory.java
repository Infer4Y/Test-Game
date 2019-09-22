package common.containers;

public interface IInventory {
    ISlot getSlot(int slot);
    void setSlot(ISlot slot);
}
