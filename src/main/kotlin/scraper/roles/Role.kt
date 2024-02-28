package scraper.roles

import scraper.allocators.Allocator
import screeps.api.Creep

enum class RoleId{
    IDLE,
    BOOTSTRAP,
    HARVEST,
    UPGRADE,
    BUILD,
    REPAIR,
    DEFEND,
}

interface Role {
    fun getAllocator(): Allocator
    fun execute(creep: Creep)
}