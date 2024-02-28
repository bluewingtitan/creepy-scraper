package scraper.roles

import scraper.allocators.DoubleCarryWCMAllocator
import scraper.tasks.TaskId

class HarvestRole: TaskBasedRole(
        arrayOf(TaskId.HARVEST, TaskId.FILL_SPAWNER, TaskId.FILL_EXTENSION, TaskId.FILL_CONTAINER),
        DoubleCarryWCMAllocator.instance
)