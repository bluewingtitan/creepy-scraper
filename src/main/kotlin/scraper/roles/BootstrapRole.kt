package scraper.roles

import scraper.allocators.MinimalWCMAllocator
import scraper.tasks.TaskId

/**
 * Early game role. Harvests, fills spawners and extensions, then upgrades.
 */
class BootstrapRole: TaskBasedRole(
        arrayOf(TaskId.HARVEST, TaskId.FILL_SPAWNER, TaskId.FILL_EXTENSION, TaskId.FILL_CONTAINER, TaskId.UPGRADE),
        MinimalWCMAllocator.instance
)