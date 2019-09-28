package common.item;

public abstract class Item {
    protected String name;

    public Item(String name) {
        this.name = name;
    }

    public abstract void onItemUse(); // Of the event if user right click while holding the item in active slot.
}
