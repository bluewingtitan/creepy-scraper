package scraper.allocators

import screeps.api.BodyPartConstant
import screeps.api.CARRY
import screeps.api.MOVE
import screeps.api.WORK
import kotlin.math.floor

class DoubleCarryWCMAllocator: Allocator {
    companion object {
        public final val instance: Allocator = DoubleCarryWCMAllocator()
    }

    override fun allocate(cost: Int, max: Int): Array<BodyPartConstant>? {
        val possibleTotal = floor(max/250f)
        val total = floor(cost /250f)

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
            res.add(CARRY)
            res.add(MOVE)
        }

        return res.toTypedArray()
    }
}