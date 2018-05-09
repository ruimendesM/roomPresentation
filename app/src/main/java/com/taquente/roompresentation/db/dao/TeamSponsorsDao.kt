package com.taquente.roompresentation.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.taquente.roompresentation.db.entities.Sponsor
import com.taquente.roompresentation.db.entities.Team
import com.taquente.roompresentation.db.entities.TeamSponsorJoin

@Dao
interface TeamSponsorsDao {

    @Insert
    fun insert(teamSponsorJoin: TeamSponsorJoin)

    @Query("SELECT * FROM Teams INNER JOIN Team_Sponsor_Join ON Teams.id = Team_Sponsor_Join.teamId WHERE Team_Sponsor_Join.sponsorId =:sponsorId")
    fun getTeamsForSponsor(sponsorId: Int): List<Team>

    @Query("SELECT * FROM Sponsors INNER JOIN Team_Sponsor_Join ON Sponsors.id = Team_Sponsor_Join.sponsorId WHERE Team_Sponsor_Join.teamId =:teamId")
    fun getSponsorsForTeam(teamId: Int): List<Sponsor>
}