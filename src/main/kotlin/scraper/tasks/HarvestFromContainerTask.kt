package scraper.tasks

import screeps.api.*
import screeps.api.structures.*

class HarvestFromContainerTask: Task {
    override fun execute(creep: Creep): TaskResult {

        if (creep.store.getFreeCapacity() <= 0){
            return TaskResult.Succeeded
        }

        val filter: FilterOption<Structure> = object : FilterOption<Structure> {
            override var filter: ((Structure) -> Boolean)? = {
                it.structureType == STRUCTURE_CONTAINER && (it.unsafeCast<StoreOwner>()).store[RESOURCE_ENERGY] > 0
            }
        }


        val nextSource = creep.room.find(FIND_MY_STRUCTURES, filter).firstOrNull() ?: return TaskResult.Succeeded

        if (creep.withdraw(nextSource.unsafeCast<StoreOwner>(), RESOURCE_ENERGY) == ERR_NOT_IN_RANGE){
            creep.moveTo(nextSource)
        }

        if (creep.store.getFreeCapacity() < 1){
            return TaskResult.Succeeded
        }

        return TaskResult.Unfinished
    }
}