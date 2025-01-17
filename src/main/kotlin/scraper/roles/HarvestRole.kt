package scraper.roles

import scraper.allocators.DoubleCarryWCMAllocator
import scraper.tasks.TaskId

class HarvestRole: TaskBasedRole(
        arrayOf(TaskId.HARVEST, TaskId.FILL_CONTAINER, TaskId.FILL_EXTENSION, TaskId.FILL_SPAWNER),
        DoubleCarryWCMAllocator.instance
)