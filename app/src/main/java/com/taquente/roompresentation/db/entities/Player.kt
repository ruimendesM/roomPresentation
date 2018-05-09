package com.taquente.roompresentation.db.entities

import android.arch.persistence.room.*
import android.arch.persistence.room.ForeignKey.CASCADE
import com.taquente.roompresentation.model.Stats
import java.util.*

@Entity(tableName = "Players",
        indices = [Index(value = ["number", "teamId"], unique = true)],
        foreignKeys = [ForeignKey(entity = Team::class, parentColumns = ["id"], childColumns = ["teamId"], onDelete = CASCADE)])
data class Player(@PrimaryKey(autoGenerate = true) val id: Int,
                  val number: Int,
                  val name: String,
                  @Embedded val stats: Stats,
                  val birthdate: Date,
                  val teamId: Int)

