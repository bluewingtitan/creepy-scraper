package scraper

import scraper.roles.*
import scraper.stages.DefaultStage
import scraper.stages.FixedStage
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
            Pair(TaskId.REPAIR, RepairTask()),
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
            Pair(RoleId.REPAIR, RepairRole())
            // TODO: Defend Role
    )

    fun getRole(id: Enum<RoleId>): Role? {
        if (roles.contains(id)){
            return roles[id]
        }

        return null
    }


    private final val stages: Map<Int, Stage> = mapOf(
            Pair(0, DefaultStage()),
            Pair(1, DefaultStage()),

            Pair(2, FixedStage(mapOf(
                    Pair(RoleId.BOOTSTRAP, 2),
                    Pair(RoleId.HARVEST, 2),
                    Pair(RoleId.UPGRADE, 2),
                    Pair(RoleId.BUILD, 2),
                    Pair(RoleId.REPAIR, 2),

                    ))),
            Pair(3, FixedStage(mapOf(
                    Pair(RoleId.BOOTSTRAP, 2),
                    Pair(RoleId.HARVEST, 2),
                    Pair(RoleId.UPGRADE, 2),
                    Pair(RoleId.BUILD, 2),
                    Pair(RoleId.REPAIR, 2),

                    ))),
            Pair(4, FixedStage(mapOf(
                    Pair(RoleId.BOOTSTRAP, 2),
                    Pair(RoleId.HARVEST, 2),
                    Pair(RoleId.UPGRADE, 2),
                    Pair(RoleId.BUILD, 2),
                    Pair(RoleId.REPAIR, 2),

                    ))),
            Pair(5, FixedStage(mapOf(
                    Pair(RoleId.BOOTSTRAP, 2),
                    Pair(RoleId.HARVEST, 2),
                    Pair(RoleId.UPGRADE, 2),
                    Pair(RoleId.BUILD, 2),
                    Pair(RoleId.REPAIR, 2),

                    ))),
    )

    fun getStage(id: Int): Stage {
        if (stages.contains(id)){
            return stages[id]!!
        }

        return DefaultStage()
    }



}