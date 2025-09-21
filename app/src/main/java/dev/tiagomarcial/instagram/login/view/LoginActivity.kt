package dev.tiagomarcial.instagram.login.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.tiagomarcial.instagram.R

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmail: TextInputEditText
    private lateinit var editTextPassword: TextInputEditText
    private lateinit var buttonLogin: LoadingButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextEmail = findViewById(R.id.login_edit_email)
        editTextPassword = findViewById(R.id.login_edit_password)
        buttonLogin = findViewById(R.id.login_btn_enter)


        buttonLogin.isEnabled = false


        editTextEmail.addTextChangedListener(watcher)
        editTextPassword.addTextChangedListener(watcher)

        buttonLogin.setOnClickListener {
            buttonLogin.showProgress(true)

            findViewById<TextInputLayout>(R.id.login_edit_email_input).error = "E-mail inválido"
            findViewById<TextInputLayout>(R.id.login_edit_email_password_input).error = "Senha inválida"

            android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                buttonLogin.showProgress(false)
            }, 2000)
        }
    }

    private val watcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            validateFields()
        }
    }

    private fun validateFields() {
        val email = editTextEmail.text?.toString() ?: ""
        val password = editTextPassword.text?.toString() ?: ""
        val isEmailValid = email.contains("@")
        val isPasswordValid = password.isNotEmpty()

        buttonLogin.isEnabled = isEmailValid && isPasswordValid
    }
}

