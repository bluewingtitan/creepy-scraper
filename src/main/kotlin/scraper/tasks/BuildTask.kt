package scraper.tasks

import screeps.api.*

class BuildTask: Task {
    override fun execute(creep: Creep): TaskResult {
        if (creep.store[RESOURCE_ENERGY] < 1){
            return TaskResult.Succeeded
        }

        val targets = creep.room.find(FIND_MY_CONSTRUCTION_SITES)

        if (targets.isNotEmpty()){
            if (creep.build(targets[0]) == ERR_NOT_IN_RANGE){
                creep.moveTo(targets[0])
            }
        }

        if (targets.isEmpty() || creep.store[RESOURCE_ENERGY] < 1){
            return TaskResult.Succeeded
        }

        return TaskResult.Unfinished
    }
}