package me.dio.web.meuportfliogithub.view

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.dio.web.meuportfliogithub.databinding.ItemRepositoryBinding
import me.dio.web.meuportfliogithub.domain.User

class AdapterUser(private val users: List<User>): RecyclerView.Adapter<AdapterUser.ViewHolder>() {

    // Create
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // View Holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Position User
        var user = users[position]

        // binding View
        holder.binding.titleRepositoryItem.text = user.name.toString()
        holder.binding.descriptionRepositoryItem.text = user.description.toString()
        holder.binding.starNumberRepositoryItem.text = user.star.toString()

        // Language
        if(user.language.isNullOrBlank()) {
            holder.binding.languageRepositoryItem.text = ""
        } else {
            holder.binding.languageRepositoryItem.text = user.language.toString()
        }

        // Click Card Layout
        // Open Url do GitHub Repository
        holder.binding.idCardLayout.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(user.url))
            it.context.startActivity(intent)
        }
    }

    // Item Count
    override fun getItemCount(): Int = users.size

    // Class View Holder
    class ViewHolder(val binding: ItemRepositoryBinding): RecyclerView.ViewHolder(binding.root) {}
}
