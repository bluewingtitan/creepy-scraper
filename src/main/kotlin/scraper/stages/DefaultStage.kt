package scraper.stages

import scraper.roles.RoleId

class DefaultStage: FixedStage(mapOf(Pair(RoleId.BOOTSTRAP, 4)))