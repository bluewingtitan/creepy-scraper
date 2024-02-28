package scraper

import screeps.api.*


fun gameLoop(){
    for (creepPair in Game.creeps){
        val creep = creepPair.component2()

        val role = Manager.getRole(creep.memory.role)

        if (role == null){
            console.log("Tried to get role " + creep.memory.role.toString() + " but found nothing.")
            continue
        }

        role.execute(creep)
    }

    // try to fulfill stage for each room.
    for (roomPair in Game.rooms){
        val room = roomPair.component2()

        if (room.controller == null)
            continue

        val stage = Manager.getStage(room.controller!!.level)


    }


}