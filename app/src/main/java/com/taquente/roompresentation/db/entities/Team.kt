package com.taquente.roompresentation.db.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Teams")
data class Team(@PrimaryKey val id: Int, val name: String)