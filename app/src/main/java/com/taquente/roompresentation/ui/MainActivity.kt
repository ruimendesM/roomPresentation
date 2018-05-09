package com.taquente.roompresentation.ui

import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.taquente.roompresentation.R
import com.taquente.roompresentation.db.AppDatabase
import com.taquente.roompresentation.db.entities.Player
import com.taquente.roompresentation.db.entities.Sponsor
import com.taquente.roompresentation.db.entities.Team
import com.taquente.roompresentation.db.entities.TeamSponsorJoin
import com.taquente.roompresentation.model.Stats
import java.util.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(this, AppDatabase::class.java, "db.db")
                .allowMainThreadQueries()// For the sake of simplicity we allow main thread queries! But really... You should not do this!
                .build()

        initData()

        getTopScorers()
        getAllTeamWithPlayers()
        getSponsorsForTeam()
        deleteTeam()
    }

    private fun initData() {
        // delete all previous data
        database.playersDao().deleteAll()
        database.teamsDao().deleteAll()
        database.sponsorsDao().deleteAll()

        // insert sponsors
        database.sponsorsDao().addSponsor(Sponsor(1, "Nike"))
        database.sponsorsDao().addSponsor(Sponsor(2, "Adidas"))
        database.sponsorsDao().addSponsor(Sponsor(3, "Super Bock"))

        // insert teams
        database.teamsDao().addTeam(Team(1, "Fc Porto"))
        database.teamsDao().addTeam(Team(2, "SL Benfica"))

        // insert relations between sponsors and teams
        database.teamSponsorsDao().insert(TeamSponsorJoin(1, 1))
        database.teamSponsorsDao().insert(TeamSponsorJoin(2, 2))
        database.teamSponsorsDao().insert(TeamSponsorJoin(1, 3))
        database.teamSponsorsDao().insert(TeamSponsorJoin(2, 3))

        // insert players to database
        database.playersDao().addPlayer(Player(0, 9, "Jackson Martinez", Stats(40, 30, 1), Date(), 1))
        database.playersDao().addPlayer(Player(0, 10, "Deco", Stats(23, 10, 25), Date(), 1))
        database.playersDao().addPlayer(Player(0, 11, "Moussa Marega", Stats(25, 40, 30), Date(), 1))

        database.playersDao().addPlayer(Player(0, 28, "Fernando Aguiar", Stats(30, 1, 0), Date(), 2))

        // Update a player info
        database.playersDao().updatePlayers(arrayOf(Player(0, 11, "Moussa Marega", Stats(26, 42, 30), Date(), 1)))
    }


    private fun getTopScorers() {
        val topScorers = database.playersDao().getTopScorers()
        Log.d(TAG, "Query 1:\n------------------\nList of Top Scorers: \n------------------\n$topScorers\n------------------")
    }

    private fun getAllTeamWithPlayers() {
        val teamsWithPlayers = database.teamsDao().getAllTeams()
        Log.d(TAG, "Query 2:\n------------------\nList of Teams With Players: \n------------------\n$teamsWithPlayers\n------------------")
    }

    private fun getSponsorsForTeam() {
        val sponsorsForTeam = database.teamSponsorsDao().getSponsorsForTeam(1)
        Log.d(TAG, "Query 3:\n------------------\nSponsors for team Fc Porto: \n------------------\n$sponsorsForTeam\n------------------")

        val teamsForSponsor = database.teamSponsorsDao().getTeamsForSponsor(3)
        Log.d(TAG, "Query 4:\n------------------\nTeams with Sponsor Super Bock: \n------------------\n$teamsForSponsor\n------------------")
    }

    private fun deleteTeam() {
        database.teamsDao().deleteById(2)
        val players = database.playersDao().getAllPlayerNames()
        Log.d(TAG, "Query 5:\n------------------\nList of player names after deleting Team 2: \n------------------\n$players\n------------------")

        val teams = database.teamSponsorsDao().getTeamsForSponsor(3)
        Log.d(TAG, "Query 6:\n------------------\nTeams with Sponsor Super Bock after deleting Team 2: \n------------------\n$teams\n------------------")
    }


}