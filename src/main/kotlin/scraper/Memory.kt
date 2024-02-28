package scraper

import scraper.roles.RoleId
import screeps.api.*
import screeps.utils.memory.memory

var CreepMemory.role by memory(RoleId.IDLE)
var CreepMemory.taskIndex:Int by memory{0}
var CreepMemory.homeRoomName:String by memory{""}


