package common.block

abstract class BlockColored(name: String) : Block(name) {

    internal enum class Colors private constructor(var _name: String, var color: Int) {
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
        LIGHT_GRAY("light_grey", 0xCCC)
    }
}
