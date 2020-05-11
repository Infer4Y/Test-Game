package inferno.common.item;

public abstract class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public void onItemUse(){}

    public String getName() { return name; }
}
