package scraper.allocators
import screeps.api.*

class MinimalWCMAllocator: Allocator {
    companion object {
        public final val instance: Allocator = MinimalWCMAllocator()
    }

    override fun allocate(cost: Int, max: Int): Array<BodyPartConstant>? {
        if (cost < 200){
            return null
        }

        return arrayOf(WORK, CARRY, MOVE)
    }
}