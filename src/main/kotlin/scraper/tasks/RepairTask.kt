package scraper.tasks

import screeps.api.*

class RepairTask: Task {
    override fun execute(creep: Creep): TaskResult {
        if (creep.store[RESOURCE_ENERGY] < 1){
            return TaskResult.Succeeded
        }

        var targets = creep.room.find(FIND_MY_STRUCTURES).filter { it.hits < it.hitsMax }
        targets = targets.sortedBy { it.hits }

        if (targets.isNotEmpty()){
            if (creep.repair(targets[0]) == ERR_NOT_IN_RANGE){
                creep.moveTo(targets[0])
            }
        }

        if (targets.isEmpty() || creep.store[RESOURCE_ENERGY] < 1){
            return TaskResult.Succeeded
        }

        return TaskResult.Unfinished
    }
}