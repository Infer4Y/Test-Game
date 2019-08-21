package xavier.project_iodine.common.item;

import java.awt.*;

public class ItemIngot extends Item {
    private int color;

    public ItemIngot(String name, int color) {
        super(name);
        this.color = color;
    }

    public ItemIngot(String name) {
        super(name);
        this.color = 0xFFFFF;
    }

    public int getColor() {
        return  color;
    }
}
