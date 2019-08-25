package xavier.project_iodine.common.block;

import com.badlogic.gdx.graphics.Color;
import xavier.project_iodine.client.BlockColoredRenderer;
import xavier.project_iodine.client.BlockRenderer;

public class BlockColored extends Block {
    private ColorState colorState;

    public BlockColored(String name) {
        super(name, true);
        setRenderer(new BlockColoredRenderer(this));
    }

    public BlockColored(String name, boolean b) {
        super(name, b);
        setRenderer(new BlockColoredRenderer(this));
    }

    public ColorState getColorState() {
        return colorState;
    }

    public BlockColored[] getRegistyInstance(BlockColored single){
        BlockColored[] instance = new BlockColored[ColorState.values().length];
        for (int i = 0; i < ColorState.values().length; i++) {
            BlockColored temp = new BlockColored(single.getName() + "_" + ColorState.values()[i].get_name());
            temp.colorState = ColorState.values()[i];
            instance[i] = temp;
        }
        return instance;
    }

    public enum ColorState{
        RED(Color.FIREBRICK, "red"),
        ORANGE(Color.ORANGE, "orange"),
        YELLOW(Color.YELLOW, "yellow"),
        GREEN(Color.GREEN, "green"),
        BLUE(Color.BLUE, "blue"),
        PURPLE(Color.PURPLE, "purple"),;

        private String _name;
        private Color _color;

        ColorState(Color color, String name) {
            _name =  name;
            _color = color;
        }

        public String get_name() {
            return _name;
        }

        public Color get_color() {
            return _color;
        }
    }
}
