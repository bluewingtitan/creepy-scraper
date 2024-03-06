package scraper.roles

import scraper.allocators.DoubleCarryWCMAllocator
import scraper.tasks.TaskId

class SpawnSupportRole: TaskBasedRole(
        arrayOf(TaskId.HARVEST, TaskId.HARVEST_FROM_CONTAINER, TaskId.FILL_EXTENSION, TaskId.FILL_SPAWNER),
        DoubleCarryWCMAllocator.instance
)