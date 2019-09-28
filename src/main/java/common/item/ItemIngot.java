package common.item;

import java.awt.*;

/** This can be made more abstract. Why not an interface for making an Item colorable? and implement it here?
 * Or at the very least, an abstract class ItemColorable?
 * **/
@Deprecated
public class ItemIngot extends Item {
    private int color;

    public ItemIngot(String name, int color) {
        super(name);
        this.color = color;
    }

    public ItemIngot(String name) {
        super(name);
        this.color = 0xFFF;
    }

    public Color getColor() {
        return  new Color(color);
    }
}
