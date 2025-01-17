package scraper.allocators

import screeps.api.*
import kotlin.math.cos
import kotlin.math.floor

class UniformWCMAllocator: Allocator {
    companion object {
        public final val instance: Allocator = UniformWCMAllocator()
    }

    override fun allocate(cost: Int, max: Int): Array<BodyPartConstant>? {
        val possibleTotal = floor(max/200f)
        val total = floor(cost /200f)

        // only allocate if at least 75% of the maximum are possible currently.
        if (total/possibleTotal < 0.75){
            return null
        }

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