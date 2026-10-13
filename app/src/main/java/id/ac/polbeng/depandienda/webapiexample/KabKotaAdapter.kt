package id.ac.polbeng.depandienda.webapiexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.ac.polbeng.depandienda.webapiexample.databinding.ItemKabKotaBinding

class KabKotaAdapter(private val listKabKota: List<KabKota>) :
    RecyclerView.Adapter<KabKotaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemKabKotaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listKabKota[position]
        holder.binding.tvKabKota.text = item.kabupatenKota
        holder.binding.tvPusatPemerintahan.text = "Pusat Pemerintahan: ${item.pusatPemerintahan}"
        holder.binding.tvBupatiWalikota.text = "Bupati/Walikota: ${item.bupatiWalikota}"

        val logoUrl = "https://kabkota.polbeng.web.id/image/logo/${item.logo}"
        Glide.with(holder.itemView.context)
            .load(logoUrl)
            .into(holder.binding.imgLogo)
    }

    override fun getItemCount(): Int = listKabKota.size

    class ViewHolder(val binding: ItemKabKotaBinding) :
        RecyclerView.ViewHolder(binding.root)
}
