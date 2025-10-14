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
import dev.tiagomarcial.instagram.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.loginEditEmail.addTextChangedListener(watcher)
        binding.loginEditPassword.addTextChangedListener(watcher)


        binding.loginBtnEnter.isEnabled = false


        binding.loginBtnEnter.setOnClickListener {
            binding.loginBtnEnter.showProgress(true)

            binding.loginEditEmailInput.error = "E-mail inválido"
            binding.loginEditEmailPasswordInput.error = "Senha inválida"


            android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                binding.loginBtnEnter.showProgress(false)
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
        val email = binding.loginEditEmail.text?.toString() ?: ""
        val password = binding.loginEditPassword.text?.toString() ?: ""
        val isEmailValid = email.contains("@")
        val isPasswordValid = password.isNotEmpty()

        binding.loginBtnEnter.isEnabled = isEmailValid && isPasswordValid
    }
}

