package common.registries

abstract class RegistryNameable {
    /**
     * @return The registry name for this object
     */
    var registryName: ResourceLocation
        private set

    constructor(name: String) {
        this.registryName = ResourceLocation(name)
    }

    constructor(resourceLocation: ResourceLocation) {
        this.registryName = resourceLocation
    }

    /**
     * Sets the domain in the [registryName] if not already set
     *
     * @param domain The domain to be set in the registry name
     */
    fun setDomain(domain: String) {
        if (this.registryName.domain == null)
            this.registryName.domain = domain
    }
}
