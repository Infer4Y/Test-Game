package common.item;

import java.awt.*;

public class ItemIngot extends ItemColored {
    private int color;

    public ItemIngot(String name, int color) {
        super(name);
        this.color = color;
    }

    public ItemIngot(String name) {
        super(name);
        this.color = 0xFFF;
    }

    @Override
    public void onItemUse() { }

    public Color getColor() {
        return  new Color(color);
    }
}
