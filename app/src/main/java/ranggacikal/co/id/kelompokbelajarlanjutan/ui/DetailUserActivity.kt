package ranggacikal.co.id.kelompokbelajarlanjutan.ui

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import ranggacikal.co.id.kelompokbelajarlanjutan.databinding.ActivityDetailUserBinding
import ranggacikal.co.id.kelompokbelajarlanjutan.ui.viewmodel.DetailUserViewModel

class DetailUserActivity : AppCompatActivity() {

    companion object {
        const val ID_USER = "id_user"
    }

    lateinit var binding: ActivityDetailUserBinding
    private val detailUserViewModel: DetailUserViewModel by viewModels()
    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListener()
        callDetailuser()
        observeDetailUser()
    }

    private fun setupListener() {
        progressDialog = ProgressDialog(this@DetailUserActivity)
        progressDialog.setTitle("Memuat Data")
        progressDialog.setTitle("Sedang memuat detai data user")
        progressDialog.show()
    }

    private fun observeDetailUser() = with(detailUserViewModel) {
        userByIdObserver.observe(this@DetailUserActivity) { response ->
            if (response?.status == 1) {
                progressDialog.dismiss()
                response.dataUserById?.get(0).let {
                    binding.edtUsernameDetailUser.setText(it?.username.toString())
                    binding.edtNamaLengkapDetailUser.setText(it?.namaLengkap.toString())
                }
            } else {
                progressDialog.dismiss()
                Toast.makeText(this@DetailUserActivity, response.pesan, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun callDetailuser() = with(detailUserViewModel) {
        requestUserById(intent.getStringExtra(ID_USER).toString())
    }
}