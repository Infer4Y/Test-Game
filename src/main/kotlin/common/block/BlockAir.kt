package common.block

class BlockAir(name: String) : Block(name) {

    @Override
    override fun isSolid(): Boolean {
        return false //Is this right?
    }
}
