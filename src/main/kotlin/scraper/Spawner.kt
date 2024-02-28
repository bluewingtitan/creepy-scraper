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
        console.log("a")
        for (roleCount in stage.getRoleCounts()){
            console.log("b")
            if (roleCounts.contains(room.name) && roleCounts[room.name]!!.contains(roleCount.key)){
                console.log("c")
                val count = roleCounts[room.name]!![roleCount.key]

                if (count!! < roleCount.value){
                    if(spawn(roleCount.key, room)){
                        return
                    }else{
                        continue
                    }
                }

            }else{
                console.log("d")
                if(spawn(roleCount.key, room)){
                    return
                }else{
                    continue
                }
            }
        }


    }

    private fun spawn(roleId: RoleId, room: Room): Boolean{
        val role = Manager.getRole(roleId) ?: return false

        // try to allocate, and don't spawn if no allocation was possible.
        val allocation = role.getAllocator().allocate(room.energyAvailable) ?: return false

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