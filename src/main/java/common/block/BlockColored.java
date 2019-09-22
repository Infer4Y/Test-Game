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
        PINK("pink", 0xFAA),
        PURPLE("purple", 0xF0F),
        ORANGE("orange", 0xFA0),
        CYAN("cyan", 0xF00),
        BROWN("brown", 0xF00),
        BLACK("black", 0x000),
        GREY("grey", 0x888),
        DARK_GRAY("red", 0x555),
        LIGHT_GRAY("red", 0xCCC);

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
