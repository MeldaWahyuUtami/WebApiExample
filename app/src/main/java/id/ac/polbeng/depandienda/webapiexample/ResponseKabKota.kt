package id.ac.polbeng.depandienda.webapiexample

import com.google.gson.annotations.SerializedName

data class ResponseKabKota(
    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("data")
    val data: List<KabKota>? = null
)
