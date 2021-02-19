package com.victormagosso.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    var editEmail: EditText? = null
    var editPassword: EditText? = null

    var auth: FirebaseAuth? = null
    var firebaseConfig = FirebaseConfig()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editEmail = findViewById(R.id.editEmail)
        editPassword = findViewById(R.id.editEmail)


        var btn: Button? = findViewById(R.id.button)
        auth = firebaseConfig.getFirebaseAuth()

        btn?.setOnClickListener {

            var email = editEmail?.text.toString()
            var password = editPassword?.text.toString()
            auth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener { task ->
                    when {
                        task.isSuccessful -> {
                            Toast.makeText(
                                applicationContext,
                                "Cadastro realizado com sucesso!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
        }
    }
}