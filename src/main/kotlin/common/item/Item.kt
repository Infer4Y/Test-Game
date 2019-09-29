package common.item

import common.registries.RegistryNameable

open class Item(name: String): RegistryNameable(name) {
    var name: String
        protected set

    init {
        this.name = name
    }

    open fun onItemUse() {} // Of the event if user right click while holding the item in active slot.
}
