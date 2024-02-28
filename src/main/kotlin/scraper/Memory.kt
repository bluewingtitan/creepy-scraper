package scraper

import scraper.roles.RoleId
import screeps.api.*
import screeps.api.structures.Structure
import screeps.utils.memory.memory

var CreepMemory.role by memory(RoleId.IDLE)
var CreepMemory.taskIndex:Int by memory{0}
var CreepMemory.homeRoomId:String by memory{""}

