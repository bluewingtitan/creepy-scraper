package scraper.stages

import scraper.roles.RoleId

interface Stage {
    fun getRoleCounts(): Map<RoleId, Int>
}