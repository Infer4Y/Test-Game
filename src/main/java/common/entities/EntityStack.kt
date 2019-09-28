package common.entities

import common.item.ItemStack

class EntityStack(stack: ItemStack) : Entity(stack.item.name, 1, 1) {
    var stack: ItemStack? = null
        set(stack) = if (stack.getItem().name == "air" || stack.getAmount() <= 0) {
            this.health = 0
        } else {
            field = stack
        }

    override fun update() {}
}
