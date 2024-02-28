package scraper.roles

import scraper.allocators.Allocator
import scraper.allocators.MinimalWCMAllocator
import screeps.api.Creep

class IdleRole: Role {
    override fun getAllocator(): Allocator {
        return MinimalWCMAllocator.instance
    }

    override fun execute(creep: Creep) {
        // do nothing.
        return
    }
}