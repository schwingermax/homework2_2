package at.fh.swengb.schwinger.homeexercise2

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface NoteDao{
    @Insert
    fun insert(note: Note)



    @Query("SELECT * FROM Note")
    fun findAll(): List<Note>


    @Query("DELETE FROM Note")
    fun deleteAllNotes()
}