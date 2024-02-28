package scraper

import scraper.roles.*
import scraper.stages.DefaultStage
import scraper.stages.Stage
import scraper.tasks.*

/**
 * Source of truth for available tasks and roles.
 */
object Manager {
    private final val tasks: Map<TaskId, Task> = mapOf(
            Pair(TaskId.IDLE, IdleTask()),
            Pair(TaskId.HARVEST, HarvestTask()),
            Pair(TaskId.HARVEST_FROM_CONTAINER, HarvestFromContainerTask()),
            Pair(TaskId.FILL_SPAWNER, FillSpawnerTask()),
            Pair(TaskId.FILL_EXTENSION, FillExtensionTask()),
            Pair(TaskId.FILL_CONTAINER, FillContainerTask()),
            Pair(TaskId.UPGRADE, UpgradeTask()),
            Pair(TaskId.BUILD, BuildTask()),
    )

    fun getTask(id: TaskId): Task? {
        if (tasks.contains(id)){
            return tasks[id]
        }

        return null
    }


    private final val roles: Map<RoleId, Role> = mapOf(
            Pair(RoleId.IDLE, IdleRole()),
            Pair(RoleId.BOOTSTRAP, BootstrapRole()),
            Pair(RoleId.HARVEST, HarvestRole()),
            Pair(RoleId.UPGRADE, UpgradeRole()),
            Pair(RoleId.BUILD, BuildRole()),
            // TODO: Defend Role
    )

    fun getRole(id: Enum<RoleId>): Role? {
        if (roles.contains(id)){
            return roles[id]
        }

        return null
    }


    private final val stages: Map<Int, Stage> = mapOf(
            Pair(0, DefaultStage())
    )

    fun getStage(id: Int): Stage {
        if (stages.contains(id)){
            return stages[id]!!
        }

        return DefaultStage()
    }



}