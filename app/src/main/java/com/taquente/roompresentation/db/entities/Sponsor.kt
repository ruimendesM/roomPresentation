package com.taquente.roompresentation.db.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Sponsors")
data class Sponsor(@PrimaryKey val id: Int, val name: String)
