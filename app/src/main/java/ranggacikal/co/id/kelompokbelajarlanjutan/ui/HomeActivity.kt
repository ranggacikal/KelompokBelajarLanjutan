package ranggacikal.co.id.kelompokbelajarlanjutan.ui

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ranggacikal.co.id.kelompokbelajarlanjutan.databinding.ActivityHomeBinding
import ranggacikal.co.id.kelompokbelajarlanjutan.model.DataUserItem
import ranggacikal.co.id.kelompokbelajarlanjutan.ui.adapter.UserAdapter
import ranggacikal.co.id.kelompokbelajarlanjutan.ui.viewmodel.UserViewModel

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    private val viewModel: UserViewModel by viewModels()
    private val userAdapter by lazy {
        UserAdapter()
    }
    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupProgressDialog()
        observeDataUser()
    }

    private fun observeDataUser() {
        viewModel.getDataUser().observe(this@HomeActivity) { userList ->
            userList.let {
                progressDialog.dismiss()
                userAdapter.addDataUser(it.dataUser as List<DataUserItem>?)
                binding.rvDataUser.layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.VERTICAL, false)
                binding.rvDataUser.adapter = userAdapter
            }
        }
    }

    private fun setupProgressDialog() {
        progressDialog = ProgressDialog(this@HomeActivity)
        progressDialog.setTitle("Memuat Data")
        progressDialog.setMessage("Sedang mengambil data user")
        progressDialog.show()
    }
}