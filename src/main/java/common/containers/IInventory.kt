package common.containers

@Deprecated("Will be completely remodeled in the future.")
interface IInventory {
    fun getSlot(slot: Int): ISlot?
    fun setSlot(slot: ISlot)
}
