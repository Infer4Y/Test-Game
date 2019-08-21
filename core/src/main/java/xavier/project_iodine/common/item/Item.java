package xavier.project_iodine.common.item;

public class Item implements IItem{
    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    @Override
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
