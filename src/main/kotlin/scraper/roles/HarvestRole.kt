package scraper.roles

import scraper.allocators.UniformWCMAllocator
import scraper.tasks.TaskId

class HarvestRole: TaskBasedRole(
        arrayOf(TaskId.HARVEST, TaskId.FILL_SPAWNER, TaskId.FILL_EXTENSION, TaskId.FILL_CONTAINER),
        UniformWCMAllocator.instance
)