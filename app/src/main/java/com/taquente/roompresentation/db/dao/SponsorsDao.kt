package com.taquente.roompresentation.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.taquente.roompresentation.db.entities.Sponsor

@Dao
interface SponsorsDao {

    @Insert
    fun addSponsor(sponsor: Sponsor)

    @Query("DELETE FROM Sponsors")
    fun deleteAll()

}