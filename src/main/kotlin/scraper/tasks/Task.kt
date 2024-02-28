package scraper.tasks

import screeps.api.Creep


enum class TaskResult{

    /**
     * The task is incomplete and shall be continued next tick
     */
    Unfinished,

    /**
     * The task succeeded and the creep shall do the next one next tick
     */
    Succeeded,

    /**
     * The task is IMPOSSIBLE to be completed with this creep in the current setting.
     * It's up to the role implementation on how to handle this, one way would be to just restart all tasks from the beginning
     */
    Failed,
}

enum class TaskId{
    IDLE,
    HARVEST,
    HARVEST_FROM_CONTAINER,
    FILL_SPAWNER,
    FILL_EXTENSION,
    FILL_CONTAINER,
    UPGRADE,
    BUILD,
    REPAIR,
}

/**
 * An atomic value of work.
 * Defines a basic job that has to be executed.
 * This is done, to avoid massive amounts of code duplications.
 *
 * A role is composed of a loop executing one or multiple jobs after each other.
 */
interface Task {
    fun execute(creep: Creep): TaskResult
}