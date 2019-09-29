package common.item

import common.registries.Items

// TODO: This class should have a limit of sorts as a static variable.
class ItemStack(var item: Item, private var amount: Int) {

    fun getAmount(): Int {
        return amount
    }

    fun setAmount(amount: Int) {
        this.amount = amount
        if (this.amount == 0) {
            item = Items.getItem("air")
            this.amount = -1
        }
    }
}
