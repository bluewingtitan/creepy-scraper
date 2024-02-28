package scraper.roles

import scraper.allocators.DoubleCarryWCMAllocator
import scraper.tasks.TaskId

class UpgradeRole: TaskBasedRole(
        arrayOf(TaskId.HARVEST_FROM_CONTAINER, TaskId.HARVEST, TaskId.UPGRADE),
        DoubleCarryWCMAllocator.instance
)