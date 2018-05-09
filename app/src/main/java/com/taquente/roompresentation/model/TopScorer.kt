package com.taquente.roompresentation.model

import android.arch.persistence.room.ColumnInfo

data class TopScorer(val name: String, @ColumnInfo(name = "goals") val numberOfGoals: Int)