package scraper.roles

import scraper.allocators.Allocator
import screeps.api.Creep

enum class RoleId{
    IDLE,
    BOOTSTRAP,
    HARVEST,
    SPAWN_SUPPORT,
    UPGRADE,
    BUILD,
    REPAIR,
    DEFEND,
}

interface Role {
    fun getAllocator(): Allocator
    fun execute(creep: Creep)
}