package scraper.tasks

import scraper.homeRoomName
import screeps.api.*

class UpgradeTask: Task {
    override fun execute(creep: Creep): TaskResult {
        if (creep.store[RESOURCE_ENERGY] < 1){
            return TaskResult.Succeeded
        }

        val spawn = Game.rooms[creep.memory.homeRoomName] ?: return TaskResult.Failed
        val controller = spawn.controller ?: return TaskResult.Failed

        if (creep.upgradeController(controller) == ERR_NOT_IN_RANGE){
            creep.moveTo(controller)
        }

        if (creep.store[RESOURCE_ENERGY] < 1){
            return TaskResult.Succeeded
        }

        return TaskResult.Unfinished
    }
}