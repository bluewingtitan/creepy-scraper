package scraper

import scraper.roles.RoleId
import scraper.stages.Stage
import screeps.api.*
import screeps.utils.contains
import screeps.utils.memory.memory
import screeps.utils.toPair
import screeps.utils.unsafe.delete
import screeps.utils.unsafe.jsObject

object Spawner {

    private var roleCounts: MutableMap<String, MutableMap<RoleId, Int>> = mutableMapOf()

    fun removeDeadCreeps(){
        roleCounts.clear()

        for (creepPair in Memory.creeps){
            if (!Game.creeps.contains(creepPair.component1())){
                // creep is dead
                delete(Memory.creeps[creepPair.component1()])
            }else{
                addToMap(creepPair.component2())
            }
        }
    }

    fun addToMap(creepMemory: CreepMemory){
        if (!roleCounts.contains(creepMemory.homeRoomName)){
            roleCounts[creepMemory.homeRoomName] = mutableMapOf()
        }

        roleCounts[creepMemory.homeRoomName]!![creepMemory.role as RoleId] = (roleCounts[creepMemory.homeRoomName]!![creepMemory.role]?:0)+1
    }


    fun fulfill(stage: Stage, room: Room){
        for (roleCount in stage.getRoleCounts()){
            if (roleCounts.contains(room.name) && roleCounts[room.name]!!.contains(roleCount.key)){
                val count = roleCounts[room.name]!![roleCount.key]

                if (count!! < roleCount.value){
                    spawn(roleCount.key, room)
                    return
                }

            }else{
                console.log("d")
                spawn(roleCount.key, room)
                return
            }
        }


    }

    private fun spawn(roleId: RoleId, room: Room): Boolean{
        val role = Manager.getRole(roleId) ?: return false

        // try to allocate, and don't spawn if no allocation was possible.
        val allocation = role.getAllocator().allocate(room.energyAvailable, room.energyCapacityAvailable) ?: return false

        val spawn = room.find(FIND_MY_SPAWNS).firstOrNull { it.spawning == null } ?: return false

        val newName = "${roleId.toString()}_${Game.time}"
        val ret = spawn.spawnCreep(allocation, newName, options {
            memory = jsObject<CreepMemory> {
                this.role = roleId
                this.homeRoomName = room.name
                this.taskIndex = 0
            }
        })

        if (ret != OK){
            console.warn("Failed to spawn creep with error code $ret")
            return false
        }

        return true
    }

}