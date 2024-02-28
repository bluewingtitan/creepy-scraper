package scraper.tasks

import screeps.api.*
import screeps.api.structures.*

abstract class FillTask<T: StoreOwner>(private val con: StructureConstant): Task {

    override fun execute(creep: Creep): TaskResult {
        if (creep.store[RESOURCE_ENERGY] < 1){
            return TaskResult.Succeeded
        }

        val filter: FilterOption<Structure> = object : FilterOption<Structure> {
            override var filter: ((Structure) -> Boolean)? = {
                it.structureType == con && (it.unsafeCast<StoreOwner>()).store.getFreeCapacity() > 0
            }
        }

        val nextSource = creep.pos.findClosestByRange(FIND_MY_STRUCTURES, filter)

        if (nextSource != null && creep.transfer((nextSource.unsafeCast<StoreOwner>()), RESOURCE_ENERGY) == ERR_NOT_IN_RANGE){
            creep.moveTo(nextSource)
        }

        if (creep.store[RESOURCE_ENERGY] < 1){
            return TaskResult.Succeeded
        }

        return TaskResult.Unfinished
    }
}