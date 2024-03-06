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
                it.structureType == con && (it.unsafeCast<T>()).store.getFreeCapacity(RESOURCE_ENERGY) > 0
            }
        }

        val nextSource = creep.room.find(FIND_MY_STRUCTURES, filter).firstOrNull() ?: return TaskResult.Succeeded // nothing to fill if returned zero.

        if (creep.transfer((nextSource.unsafeCast<T>()), RESOURCE_ENERGY) == ERR_NOT_IN_RANGE){
            creep.moveTo(nextSource)
        }


        if (creep.store[RESOURCE_ENERGY] < 1){
            return TaskResult.Succeeded
        }

        return TaskResult.Unfinished
    }
}