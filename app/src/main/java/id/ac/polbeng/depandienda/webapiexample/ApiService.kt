package id.ac.polbeng.depandienda.webapiexample

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/read_kabkota.php")
    fun getKabKota(): Call<ResponseKabKota>
}
