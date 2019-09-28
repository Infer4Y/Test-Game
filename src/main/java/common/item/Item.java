package common.item;

public class Item {
    protected String name;

    public Item(String name) {
        this.name = name;
    }

    public void onItemUse(){} // Of the event if user right click while holding the item in active slot.

    public String getName() {
        return name;
    }
}
