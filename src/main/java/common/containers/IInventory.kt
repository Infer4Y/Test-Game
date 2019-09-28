package common.containers

interface IInventory {
    fun getSlot(slot: Int): ISlot
    fun setSlot(slot: ISlot)
}
