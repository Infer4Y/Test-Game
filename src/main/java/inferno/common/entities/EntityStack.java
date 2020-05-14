package inferno.common.entities;

import inferno.common.item.ItemStack;
import inferno.common.world.World;
import org.joml.Vector2f;

public class EntityStack extends Entity {
    private ItemStack stack;

    public EntityStack(ItemStack stack) {
        super(stack.getItem().getName(), 0,0);
        setKillable(false);
    }

    @Override
    public void onCollision(World world, Entity target, Vector2f location) {
        super.onCollision(world, target, location);
        if (target instanceof Player){

            this.onDeath(world);

            world.removeEntity(this);
        }
    }

    public ItemStack getStack(){
        return stack;
    }

    public void setStack(ItemStack stack){
        if (stack.getItem().getName().equals("air") || stack.getAmount() <=0 ){
            this.setKillable(true);
            this.setHealth(-99);
        } else {
            this.stack = stack;
        }
    }
}
