package edu.rvc.student.preference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val et1 = findViewById<EditText>(R.id.txtEmail) as EditText
        val preferences = getSharedPreferences("data", Context.MODE_PRIVATE)

        et1.setText (preferences.getString ("mail", ""))
        val button1 = findViewById<Button>(R.id.btnSubmit) as Button

        button1.setOnClickListener {
            val editor = preferences.edit()
            editor.putString("mail", txtEmail.text.toString())
            editor.commit()
            finish()
            }
            findViewById<View>(android.R.id.content).setOnTouchListener { _, _ ->
                hideKeyboard()
                false
            }
        }

        //function to hide keyboard goes right before the last right bracket of Class MainActivity
//should auto import android.content.Context
//should auto add import android.view.inputmethod.InputMethodManager
        fun hideKeyboard() {
            try {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            } catch (e: Exception) {
                // TODO: handle exception
            }

        }
    }
