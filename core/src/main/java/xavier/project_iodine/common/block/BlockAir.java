package xavier.project_iodine.common.block;

public class BlockAir extends Block {
    public BlockAir(String name) {
        super(name);
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public boolean isAir() {
        return true;
    }
}
