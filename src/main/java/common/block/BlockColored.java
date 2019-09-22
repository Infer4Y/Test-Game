package common.block;

public class BlockColored extends Block{


    public BlockColored(String name) {
        super(name, true);
    }

    enum Colors{
        RED("red", 0xF00),
        BLUE("blue", 0x00F),
        GREEN("green", 0x0F0),
        YELLOW("yellow", 0xFF0),
        PINK("pink", 0xffadad),
        PURPLE("purple", 0x4B04DA),
        ORANGE("orange", 0xF80),
        CYAN("cyan", 0x33fff6),
        BROWN("brown", 0x582c00),
        BLACK("black", 0x000),
        GREY("grey", 0x888),
        DARK_GRAY("dark_grey", 0x555),
        LIGHT_GRAY("light_grey", 0xCCC);

        String _name;
        int color;

        Colors(String name, int color){
            this._name = name;
            this.color = color;
        }

        public String get_name() {
            return _name;
        }

        public int getColor() {
            return color;
        }
    }
}
