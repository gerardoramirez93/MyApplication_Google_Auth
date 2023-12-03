package com.dsm_udb.myapplication_google_auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()

        val userEmailTextView: TextView = findViewById(R.id.txtUserEmail)
        val userNameTextView: TextView = findViewById(R.id.txtUserName)
        val signOutButton: Button = findViewById(R.id.btnSignOut)

        val currentUser = auth.currentUser
        if (currentUser != null) {
            userEmailTextView.text = "Correo del usuario: ${currentUser.email}"
            userNameTextView.text = "Nombre del usuario: ${currentUser.displayName}"
        }

        signOutButton.setOnClickListener {
            // Lógica para cerrar sesión
            auth.signOut()

            // Redirigir a la pantalla de inicio de sesión (MainActivity en este caso)
            val intent = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(intent)

            // Finalizar la actividad actual
            finish()
        }
    }
}
