package scraper.roles

import scraper.Manager
import scraper.allocators.Allocator
import scraper.taskIndex
import scraper.tasks.TaskId
import scraper.tasks.TaskResult
import screeps.api.Creep

abstract class TaskBasedRole(private val tasks: Array<TaskId>, private val allocator: Allocator): Role {
    override fun getAllocator(): Allocator {
        return allocator
    }

    override fun execute(creep: Creep) {
        if (creep.memory.taskIndex >= tasks.size){
            creep.memory.taskIndex = 0
        }

        val task = Manager.getTask(tasks[creep.memory.taskIndex])

        if (task == null){
            console.log("tried to execute task " + tasks[creep.memory.taskIndex].toString() + ", but couldn't find it.")
            return
        }

        val result = task.execute(creep)

        if (result == TaskResult.Succeeded){
            // execute next
            creep.memory.taskIndex++
            return
        }

        if (result == TaskResult.Failed){
            // restart task queue
            creep.memory.taskIndex = 0
            return
        }

        // unfinished will just lead to another iteration of the same task next tick
    }
}