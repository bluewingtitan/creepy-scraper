package scraper.roles

import scraper.allocators.UniformWCMAllocator
import scraper.tasks.TaskId

class BuildRole: TaskBasedRole(
        arrayOf(TaskId.HARVEST_FROM_CONTAINER, TaskId.HARVEST, TaskId.BUILD),
        UniformWCMAllocator.instance
)