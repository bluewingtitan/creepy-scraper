package scraper.roles

import scraper.allocators.DoubleCarryWCMAllocator
import scraper.allocators.UniformWCMAllocator
import scraper.tasks.TaskId

class BuildRole: TaskBasedRole(
        arrayOf(TaskId.HARVEST_FROM_CONTAINER, TaskId.HARVEST, TaskId.BUILD, TaskId.REPAIR),
        DoubleCarryWCMAllocator.instance
)