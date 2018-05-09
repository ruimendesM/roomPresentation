package com.taquente.roompresentation.db.dao

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.taquente.roompresentation.db.entities.Player
import com.taquente.roompresentation.model.TopScorer

@Dao
interface PlayersDao {

    enum class OrderBy {
        NUMBER,
        NAME;

        override fun toString(): String {
            return when (this) {
                NUMBER -> "number"
                NAME -> "name"
            }
        }
    }

    @Query("SELECT * FROM players ORDER BY :orderBy")
    fun getAllPlayers(orderBy: String): List<Player>

    @Query("SELECT * FROM players WHERE id LIKE :playerId")
    fun getPlayerById(playerId: Int): Player

    @Query("SELECT * FROM players WHERE id IN(:playerId)")
    fun getPlayerById(playerId: Array<Int>): List<Player>

    @Query("SELECT name FROM players")
    fun getAllPlayerNames(): List<String>

    @Query("SELECT name, goals FROM players ORDER BY goals DESC")
    fun getTopScorers(): List<TopScorer>

    @Query("SELECT COUNT(*) FROM players")
    fun countPlayers(): Int

    @Query("SELECT * FROM players WHERE teamId=:teamId")
    fun findRepositoriesForUser(teamId: Int): List<Player>

    @Insert
    fun addPlayer(player: Player)

    @Insert(onConflict = REPLACE)
    fun addPlayers(players: List<Player>)

    @Update
    fun updatePlayers(players: Array<Player>)

    @Delete
    fun deletePlayer(player: Player)

    @Query("DELETE FROM Players")
    fun deleteAll()
}