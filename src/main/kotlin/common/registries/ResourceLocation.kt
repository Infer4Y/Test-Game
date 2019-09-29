package common.registries

import common.Game
import org.apache.commons.lang3.builder.EqualsBuilder
import java.io.InputStream

class ResourceLocation {
    /**
     * @return The folder to get the assets from. Ex '/assets/domain'
     */
    /**
     * Sets the domain of this resource location
     * @param domain Resource domain
     */
    var domain: String? = null
    /**
     * @return The actual location to the asset. Used after domain as '/assets/domain/location'
     */
    var location: String? = null
        private set

    /**
     * @return The path to the resource
     */
    val path: String
        get() = "/assets/" + this.domain + "/" + this.location

    /**
     * @return An input stream that leads strait to the asset
     */
    val inputStream: InputStream
        get() = ResourceLocation::class.java.getResourceAsStream(this.path) ?: InputStream.nullInputStream()

    constructor(location: String) {
        val resourceLocationRaw = location.split(":".toRegex(), 2).toTypedArray()
        if (resourceLocationRaw.size > 1) {
            this.domain = resourceLocationRaw[0]
            this.location = resourceLocationRaw[1]
        } else {
            this.domain = Game.NAME // Domain of the Game
            this.location = location
        }
    }

    constructor(domain: String, location: String) {
        this.domain = domain
        this.location = location
    }

    constructor(folder: ResourceLocation, location: String) {
        this.location = folder.domain + ":" + folder.location + "/" + location
    }

    override fun hashCode(): Int {
        var result = 1
        result = 31 * result + if (this.domain == null) 0 else this.domain!!.hashCode()
        result = 31 * result + if (this.location == null) 0 else this.location!!.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (obj == null) {
            return false
        }
        if (this === obj) {
            return true
        }
        if (this.javaClass != obj.javaClass) {
            return false
        }
        val other = obj as ResourceLocation?
        return EqualsBuilder()
                .append(this.domain, other!!.domain)
                .append(this.location, other.location)
                .isEquals
    }

    override fun toString(): String {
        return this.domain + ":" + this.location
    }
}
