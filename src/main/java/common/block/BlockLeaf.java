package common.block;

public class BlockLeaf extends Block {
    public BlockLeaf(String name) {
        super(name);
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
