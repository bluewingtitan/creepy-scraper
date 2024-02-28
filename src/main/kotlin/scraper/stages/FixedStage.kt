package scraper.stages

import scraper.roles.RoleId

open class FixedStage(private val stage: Map<RoleId, Int>) : Stage{
    override fun getRoleCounts(): Map<RoleId, Int> {
        return stage
    }
}