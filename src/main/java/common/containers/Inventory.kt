package common.containers

class Inventory {
    private var slots: Array<ISlot?>

    constructor() {
        slots = arrayOfNulls(10)
    }

    constructor(size: Int) {
        slots = arrayOfNulls(size)
    }

    fun getSlot(slot: Int): ISlot? {
        return if (slots.size < slot || slot < 0) null else slots[slot]
    }

    fun setSlot(slot: ISlot) {
        // TODO: Add a way to check if slot has the item or if no slot has item go to first air item found.
    }
}
