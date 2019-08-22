package xavier.project_iodine.common.containers;

public interface IInventory {
    ISlot getSlot(int id);
    void setSlot(ISlot slot, int id);
}
