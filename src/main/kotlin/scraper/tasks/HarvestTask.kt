package scraper.tasks

import screeps.api.*
import screeps.api.structures.Structure

class HarvestTask: Task {
    override fun execute(creep: Creep): TaskResult {
        if (creep.store.getFreeCapacity() < 1){
            return TaskResult.Succeeded
        }

        val nextSource = creep.pos.findClosestByPath(FIND_SOURCES_ACTIVE)

        if (nextSource != null && creep.harvest(nextSource) == ERR_NOT_IN_RANGE){
            creep.moveTo(nextSource)
        }

        if (creep.store.getFreeCapacity() < 1){
            return TaskResult.Succeeded
        }

        return TaskResult.Unfinished
    }
}