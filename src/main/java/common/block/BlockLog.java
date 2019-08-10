package common.block;

public class BlockLog extends Block {
    public BlockLog(String name) {
        super(name);
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
