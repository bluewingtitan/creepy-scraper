package scraper.roles

import scraper.allocators.MinimalWCMAllocator
import scraper.tasks.TaskId

/**
 * Spawned in a panic. Only job is to get more energy to spawn higher tier creeps.
 */
class Reviver: TaskBasedRole(
        arrayOf(TaskId.HARVEST_FROM_CONTAINER, TaskId.HARVEST, TaskId.FILL_SPAWNER, TaskId.FILL_EXTENSION),
        MinimalWCMAllocator.instance
)