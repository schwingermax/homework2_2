package at.fh.swengb.schwinger.homeexercise2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun store(view: View) {
        if (name_user.text.isEmpty() || /*and*/  age_user.text.isEmpty()) {
            name_user.hint = "Insert NAME"
            age_user.hint = "Insert AGE"
            insert_text.text = "Please insert NAME and AGE"
            /* Folgende Idee hat leider nicht funtkioniert
            if (name_user.text.isEmpty() and age_user.text.isNotEmpty()){
             Log.i("EmptyAct", "Insert TExt")
             insert_text.text = "PLEASE INSERT NAME"}
             if (age_user.text.isEmpty() and name_user.text.isNotEmpty()){
                 Log.i("EmptyAct", "Insert TExt")
                 insert_text.text = "PLEASE INSERT AGE"}*/
        } else {
            val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
            sharedPreferences.edit().putString("name", name_user.text.toString()).apply()
            Log.i("Test", "stored name")
            sharedPreferences.edit().putInt("alter", age_user.text.toString().toInt()).apply()
            Log.i("Test", "stored age succesfully")
            nextPage()
        }
    }



    private fun nextPage() {
         val intent = Intent(this, NoteListActivity::class.java)
         startActivity(intent)
         finish()
     }

}
