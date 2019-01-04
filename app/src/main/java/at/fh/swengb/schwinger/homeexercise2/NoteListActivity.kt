package at.fh.swengb.schwinger.homeexercise2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {
    private val noteAdapter = NoteAdapter()

    lateinit var db: NotesRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        db = NotesRoomDatabase.getDatabase(this)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("name", null)
        val savedInt = sharedPreferences.getInt("alter", -1)
        user_info.text = "Notes for ${savedString} ${savedInt}"

        recycler_view.adapter = noteAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        db.noteDao.findAll()
        noteAdapter.updateList(db.noteDao.findAll())
    }

    fun addNote(view: View) {
        nextPage()
    }

    fun nextPage() {
        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)
     }

    fun deleteNote(view: View) {
        db.noteDao.deleteAllNotes()
        noteAdapter.updateList(db.noteDao.findAll())
    }

}
