package com.taquente.roompresentation.db.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.Index

@Entity(tableName = "Team_Sponsor_Join",
        primaryKeys = ["teamId", "sponsorId"],
        indices = [(Index(value = ["sponsorId"]))],
        foreignKeys = [ForeignKey(entity = Team::class, parentColumns = ["id"], childColumns = ["teamId"], onDelete = CASCADE),
            (ForeignKey(entity = Sponsor::class, parentColumns = ["id"], childColumns = ["sponsorId"], onDelete = CASCADE))])
data class TeamSponsorJoin(val teamId: Int, val sponsorId: Int)