package scraper.roles

import scraper.allocators.DoubleCarryWCMAllocator
import scraper.tasks.TaskId

class RepairRole: TaskBasedRole(
        arrayOf(TaskId.HARVEST_FROM_CONTAINER, TaskId.HARVEST, TaskId.REPAIR, TaskId.BUILD),
        DoubleCarryWCMAllocator.instance
)