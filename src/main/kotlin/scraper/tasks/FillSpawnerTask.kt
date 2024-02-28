package scraper.tasks

import scraper.homeRoomName
import screeps.api.*
import screeps.api.structures.StructureSpawn

class FillSpawnerTask: Task{
    override fun execute(creep: Creep): TaskResult {
        if (creep.store[RESOURCE_ENERGY] < 1){
            return TaskResult.Succeeded
        }

        val home = Game.rooms[creep.memory.homeRoomName] ?: return TaskResult.Failed
        val spawn = home.find(FIND_MY_SPAWNS).firstOrNull() ?: return TaskResult.Failed

        if (spawn.store.getFreeCapacity(RESOURCE_ENERGY) == 0){
            return TaskResult.Succeeded
        }

        if (creep.transfer(spawn, RESOURCE_ENERGY) == ERR_NOT_IN_RANGE){
            creep.moveTo(spawn)
        }

        if (creep.store[RESOURCE_ENERGY] < 1){
            return TaskResult.Succeeded
        }

        return TaskResult.Unfinished
    }

}