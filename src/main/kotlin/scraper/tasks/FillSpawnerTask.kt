package scraper.tasks

import screeps.api.STRUCTURE_SPAWN
import screeps.api.structures.StructureSpawn

// TODO: Only fill home spawn.
class FillSpawnerTask: FillTask<StructureSpawn>(STRUCTURE_SPAWN)