package common.block;

public class BlockAir extends Block {
    public BlockAir(String name) {
        super(name);
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
