package com.taquente.roompresentation.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.taquente.roompresentation.db.converters.Converters
import com.taquente.roompresentation.db.dao.PlayersDao
import com.taquente.roompresentation.db.dao.SponsorsDao
import com.taquente.roompresentation.db.dao.TeamSponsorsDao
import com.taquente.roompresentation.db.dao.TeamsDao
import com.taquente.roompresentation.db.entities.Player
import com.taquente.roompresentation.db.entities.Sponsor
import com.taquente.roompresentation.db.entities.Team
import com.taquente.roompresentation.db.entities.TeamSponsorJoin

@Database(entities = [Player::class, Team::class, Sponsor::class, TeamSponsorJoin::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playersDao(): PlayersDao

    abstract fun teamsDao(): TeamsDao

    abstract fun sponsorsDao(): SponsorsDao

    abstract fun teamSponsorsDao(): TeamSponsorsDao
}
