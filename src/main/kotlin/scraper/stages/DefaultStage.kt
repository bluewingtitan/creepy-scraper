package scraper.stages

import scraper.roles.RoleId

class DefaultStage: Stage {
    override fun getRoleCounts(): Map<RoleId, Int> {
        return mapOf(
                Pair(RoleId.BOOTSTRAP, 4)
        )
    }
}