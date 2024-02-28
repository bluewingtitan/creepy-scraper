package scraper.tasks

import screeps.api.Creep

class IdleTask: Task {
    override fun execute(creep: Creep): TaskResult {
        return TaskResult.Succeeded
    }
}