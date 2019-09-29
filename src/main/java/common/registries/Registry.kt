package common.registries

import java.util.*
import java.util.function.Consumer
import java.util.regex.Pattern
import kotlin.collections.HashMap

class Registry<T: RegistryNameable>(val type: Class<T>) : Iterable<T> {
    private val entries = HashMap<ResourceLocation, T>()

    val all: Collection<T>
        get() = this.entries.values

    /**
     * Get an entry by its registry name
     */
    operator fun get(registryName: ResourceLocation): T? = entries[registryName]

    /**
     * Gets all entries matching the [Predicate]
     */
    operator fun get(predicate: (T) -> Boolean): Set<T> = entries.values.filter(predicate).toSet()

    /**
     * Gets all entries matching the [Predicate] and then re-maps them using the [Function]
     */
    operator fun <R> get(predicate: (T) -> Boolean, mapper: (T) -> R): Set<R> =
            entries.values.filter(predicate).map(mapper).toSet()

    /**
     * Adds the [RegistryNameable] object to this registry if it is of the correct type
     */
    fun add(`object`: RegistryNameable) {
        if (!type.isInstance(`object`)) {
            throw RuntimeException(String.format("The given %s is not of type %s for this registry", `object`.javaClass.name, type.name))
        }
        val obj = type.cast(`object`)

        // Validate registry name
        val registryName = obj.registryName
        val matcher = NAME.matcher(registryName.toString())
        if (!matcher.matches()) {
            throw RuntimeException(String.format("The given %s has an invalid registry name: %s", obj.javaClass.name, registryName))
        }

        // Validate domain
        val domain = matcher.group(1)
        // TODO: Validate that the domain name even exists
//        if (domain != ) {
//            throw RuntimeException(String.format("The given %s has a domain that does not exist: %s", obj.javaClass.name, domain))
//        }

        entries[registryName] = obj
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) {
            return true
        }
        if (other !is Registry<*>) {
            return false
        }
        val r = other as Registry<*>?
        return type.isAssignableFrom(r!!.type) || r.type.isAssignableFrom(type)
    }

    override fun iterator(): Iterator<T> = this.entries.values.iterator()

    override fun forEach(action: Consumer<in T>) {
        this.entries.values.forEach(action)
    }

    override fun spliterator(): Spliterator<T> = this.entries.values.spliterator()

    companion object {
        private val NAME = Pattern.compile("^(\\w+):\\w+$")
    }

}

