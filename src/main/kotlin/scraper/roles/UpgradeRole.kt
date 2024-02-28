package scraper.roles

import scraper.allocators.UniformWCMAllocator
import scraper.tasks.Task
import scraper.tasks.TaskId

class UpgradeRole: TaskBasedRole(
        arrayOf(TaskId.HARVEST_FROM_CONTAINER, TaskId.HARVEST, TaskId.UPGRADE),
        UniformWCMAllocator.instance
)