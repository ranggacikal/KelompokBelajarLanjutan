package ranggacikal.co.id.kelompokbelajarlanjutan.ui

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import ranggacikal.co.id.kelompokbelajarlanjutan.R
import ranggacikal.co.id.kelompokbelajarlanjutan.databinding.ActivityRegisterBinding
import ranggacikal.co.id.kelompokbelajarlanjutan.ui.viewmodel.RegisterViewModel
import java.util.UUID
import kotlin.random.Random

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListener()
        observeRegister()
    }

    private fun observeRegister() {
        registerViewModel.registerObserver.observe(this@RegisterActivity) { response ->
            if (response?.sukses == true) {
                Toast.makeText(this, response.pesan, Toast.LENGTH_SHORT).show()
                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                startActivity(intent)
            }
            else Toast.makeText(this, response.pesan, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupListener() = with(binding) {
        val id_user = UUID.randomUUID().toString()
        btnRegister.setOnClickListener {
            registerViewModel.requestRegister(
                id_user,
                edtUsername.text.toString(),
                edtPassword.text.toString(),
                edtNamaLengkap.text.toString()
            )
        }
    }
}