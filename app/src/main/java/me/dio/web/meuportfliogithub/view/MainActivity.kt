package me.dio.web.meuportfliogithub.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import me.dio.web.meuportfliogithub.R
import me.dio.web.meuportfliogithub.data.viewmodel.ViewModelUser
import me.dio.web.meuportfliogithub.databinding.ActivityMainBinding
import me.dio.web.meuportfliogithub.domain.Owner
import me.dio.web.meuportfliogithub.domain.User

class MainActivity : AppCompatActivity() {

    // Vars
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var viewModelUser: ViewModelUser
    private lateinit var userAdapter: AdapterUser

    // Create
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Recycler View
        val recyclerView = binding.recyclerViewRepository
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Binding View
        var name = binding.textNameUser
        var image = binding.imageUser

        // ViewModel
        viewModelUser = ViewModelProvider.NewInstanceFactory().create(ViewModelUser::class.java)
        initObserver(recyclerView, name, image)
        progressBarVisibility(true)
    }

    // Init Observer
    private fun initObserver(recyclerView: RecyclerView, name:TextView, image:ImageView) {
        viewModelUser.getAllRepositories().observe(this, Observer<List<User>> {
            if(it.isNotEmpty()) {
                // data header
                var owner:Owner = Owner(getString(R.string.my_name), getString(R.string.url_image))
                Picasso.get().load(owner.avatarUrl).fit().centerCrop(0).into(image);
                name.text = owner.name
                // Adapter
                userAdapter = AdapterUser(it)
                userAdapter.notifyDataSetChanged()
                recyclerView.adapter = userAdapter
                // Progress Bar
                progressBarVisibility(false)
            }
        })
    }
    // Active Progress Bar
    private fun progressBarVisibility(isLoading: Boolean) {
        var progressBar = binding.progressBar
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}