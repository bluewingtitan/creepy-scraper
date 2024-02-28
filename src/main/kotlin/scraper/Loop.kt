package scraper

import screeps.api.*


fun gameLoop(){
    // enable pixel mining
    if (Game.cpu.bucket >= 10000){
        Game.cpu.generatePixel()
        return
    }


    for (creepPair in Game.creeps){
        val creep = creepPair.component2()

        val role = Manager.getRole(creep.memory.role)

        if (role == null){
            // can't control it => can't use it.
            creepPair.component2().suicide()
            console.log("Tried to get role " + creep.memory.role.toString() + " but found nothing.")
            continue
        }

        role.execute(creep)
    }

    Spawner.removeDeadCreeps()

    // try to fulfill stage for each room.
    for (roomPair in Game.rooms){
        val room = roomPair.component2()

        if (room.controller == null)
            continue

        val stage = Manager.getStage(room.controller!!.level)

        Spawner.fulfill(stage, room)
    }


}