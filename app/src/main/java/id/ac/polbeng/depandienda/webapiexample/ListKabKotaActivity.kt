package id.ac.polbeng.depandienda.webapiexample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.polbeng.depandienda.webapiexample.databinding.ActivityListKabKotaBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListKabKotaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListKabKotaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListKabKotaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvKabKota.layoutManager = LinearLayoutManager(this)

        getKabKotaList()
    }

    private fun getKabKotaList() {
        binding.progressBar.visibility = View.VISIBLE
        val client = ApiConfig.getApiService(this).getKabKota()
        client.enqueue(object : Callback<ResponseKabKota> {
            override fun onResponse(
                call: Call<ResponseKabKota>,
                response: Response<ResponseKabKota>
            ) {
                binding.progressBar.visibility = View.GONE
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        val listData = responseBody.data
                        if (listData != null) {
                            val adapter = KabKotaAdapter(listData)
                            binding.rvKabKota.adapter = adapter
                        }
                    }
                } else {
                    Toast.makeText(
                        this@ListKabKotaActivity,
                        "Gagal mengambil data: ${response.message()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<ResponseKabKota>, t: Throwable) {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(
                    this@ListKabKotaActivity,
                    "Error: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}
