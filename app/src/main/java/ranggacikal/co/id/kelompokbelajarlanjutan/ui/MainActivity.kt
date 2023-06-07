package ranggacikal.co.id.kelompokbelajarlanjutan.ui

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import ranggacikal.co.id.kelompokbelajarlanjutan.R
import ranggacikal.co.id.kelompokbelajarlanjutan.databinding.ActivityMainBinding
import ranggacikal.co.id.kelompokbelajarlanjutan.ui.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val loginViewModel: LoginViewModel by viewModels()
    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupProgressDialog()
        setupListener()
        observeLogin()
    }

    private fun observeLogin() {
        loginViewModel.loginObserver.observe(this@MainActivity) { response ->
            if (response.sukses == true) {
                progressDialog.dismiss()
                Toast.makeText(this@MainActivity, response.pesan, Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                progressDialog.dismiss()
                Toast.makeText(this@MainActivity, response.pesan, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupListener() = with(binding) {
        btnLogin.setOnClickListener {
            progressDialog.show()
            val username = edtUsernameLogin.text.toString().trim()
            val password = edtPasswordLogin.text.toString().trim()
            loginViewModel.requestLogin(username, password)
        }
    }

    private fun setupProgressDialog() {
        progressDialog = ProgressDialog(this@MainActivity)
        progressDialog.setTitle("LOGIN")
        progressDialog.setMessage("memproses login user")
    }
}