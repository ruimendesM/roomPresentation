package com.taquente.roompresentation.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation
import com.taquente.roompresentation.db.entities.Player
import com.taquente.roompresentation.db.entities.Team

class TeamWithPlayers {
    @Embedded
    lateinit var team: Team

    @Relation(parentColumn = "id", entityColumn = "teamId")
    var players: List<Player> = ArrayList()

    override fun toString(): String {
        return team.toString() + " " + players.toString()
    }
}