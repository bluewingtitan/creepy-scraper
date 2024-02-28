package scraper.allocators

import screeps.api.*

interface Allocator {
    fun allocate(cost: Int, max: Int): Array<BodyPartConstant>?
}

