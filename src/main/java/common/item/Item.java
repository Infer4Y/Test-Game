package common.item;

public class Item implements IItem{
    private String name;

    public Item() {
    }

    public void onItemUse(){
        // Of the event if user right click while holding the item in active slot.
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
