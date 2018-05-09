package com.taquente.roompresentation.db.dao

import android.arch.persistence.room.*
import com.taquente.roompresentation.db.entities.Team
import com.taquente.roompresentation.model.TeamWithPlayers

@Dao
interface TeamsDao {

    @Insert
    fun addTeam(team: Team)

    @Update
    fun updateTeam(team: Team)

    @Delete
    fun deleteTeam(team: Team)

    @Query("DELETE FROM Teams")
    fun deleteAll()

    @Query("DELETE FROM Teams WHERE id = :teamId")
    fun deleteById(teamId: Int)

    @Transaction
    @Query("SELECT * FROM Teams")
    fun getAllTeams() : List<TeamWithPlayers>

}