package scraper.allocators
import screeps.api.*

class MinimalWCMAllocator: Allocator {
    companion object {
        public final val instance: Allocator = MinimalWCMAllocator()
    }




    override fun allocate(maxCost: Int): Array<BodyPartConstant>? {
        if (maxCost < 200){
            return null
        }

        return arrayOf(WORK, CARRY, MOVE)
    }

}