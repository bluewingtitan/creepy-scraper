package scraper.allocators

import screeps.api.*
import kotlin.math.floor

class UniformWCMAllocator: Allocator {
    companion object {
        public final val instance: Allocator = UniformWCMAllocator()
    }
    override fun allocate(maxCost: Int): Array<BodyPartConstant>? {
        val total = floor(maxCost/200f)

        if (total < 1){
            return null
        }

        var res = mutableListOf(WORK)
        res.removeAt(0)

        for (i in 0 until total.toInt()){
            res.add(WORK)
            res.add(CARRY)
            res.add(MOVE)
        }

        return res.toTypedArray()
    }

}