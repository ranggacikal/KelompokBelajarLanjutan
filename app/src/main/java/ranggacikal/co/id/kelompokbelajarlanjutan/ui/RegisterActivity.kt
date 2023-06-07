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
    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupProgressDialog()
        setupListener()
        observeRegister()
    }

    private fun setupProgressDialog() {
        progressDialog = ProgressDialog(this@RegisterActivity)
        progressDialog.setTitle("Mohon tunggu")
        progressDialog.setMessage("Register sedang di proses")
    }

    private fun observeRegister() {
        registerViewModel.registerObserver.observe(this@RegisterActivity) { response ->
            if (response?.sukses == true) {
                progressDialog.dismiss()
                Toast.makeText(this, response.pesan, Toast.LENGTH_SHORT).show()
                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                progressDialog.dismiss()
                Toast.makeText(this, response.pesan, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupListener() = with(binding) {
        val id_user = UUID.randomUUID().toString()
        btnRegister.setOnClickListener {
            progressDialog.show()
            registerViewModel.requestRegister(
                id_user,
                edtUsername.text.toString(),
                edtPassword.text.toString(),
                edtNamaLengkap.text.toString()
            )
        }
        tvLoginFromRegister.setOnClickListener {
            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}