package scraper.allocators

import screeps.api.*

interface Allocator {
    fun allocate(maxCost: Int): Array<BodyPartConstant>?
}

