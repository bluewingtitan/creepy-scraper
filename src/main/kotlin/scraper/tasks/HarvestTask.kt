package scraper.tasks

import screeps.api.Creep
import screeps.api.ERR_NOT_IN_RANGE
import screeps.api.FIND_SOURCES_ACTIVE

class HarvestTask: Task {
    override fun execute(creep: Creep): TaskResult {
        if (creep.store.getFreeCapacity() < 1){
            return TaskResult.Succeeded
        }

        val nextSource = creep.pos.findClosestByRange(FIND_SOURCES_ACTIVE)

        if (nextSource != null && creep.harvest(nextSource) == ERR_NOT_IN_RANGE){
            creep.moveTo(nextSource)
        }

        if (creep.store.getFreeCapacity() < 1){
            return TaskResult.Succeeded
        }

        return TaskResult.Unfinished
    }
}