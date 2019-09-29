package common.registries

import java.util.*

abstract class RegistryFactory<T> {
    var MAP = HashMap<String, T>()

    fun init() {}

    fun register(name: String, `object`: T) {
        MAP[name] = `object`
    }

    fun getObject(name: String): T {
        return (MAP as java.util.Map<String, T>).getOrDefault(name, null)
    }
}
