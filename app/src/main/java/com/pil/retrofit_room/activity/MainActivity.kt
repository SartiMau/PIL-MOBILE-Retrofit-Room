package com.pil.retrofit_room.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pil.retrofit_room.adapter.ExerciseAdapter
import com.pil.retrofit_room.databinding.ActivityMainBinding
import com.pil.retrofit_room.mvvm.contract.MainContract
import com.pil.retrofit_room.mvvm.model.MainModel
import com.pil.retrofit_room.mvvm.viewmodel.MainViewModel
import com.pil.retrofit_room.mvvm.viewmodel.factory.ViewModelFactory
import com.pil.retrofit_room.service.ExerciseClient
import com.pil.retrofit_room.service.ExerciseRequestGenerator
import com.pil.retrofit_room.service.ExerciseService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainContract.ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                arrayOf(
                    MainModel(
                        ExerciseService(
                            ExerciseRequestGenerator.createService(ExerciseClient::class.java),
                        ),
                    ),
                ),
            ),
        )[MainViewModel::class.java]

        viewModel.getValue().observe(this) { updateUI(it) }
    }

    private fun updateUI(data: MainViewModel.MainData) {
        when (data.status) {
            MainViewModel.MainStatus.SHOW_INFO -> {
                binding.recycler.layoutManager = LinearLayoutManager(this)
                binding.recycler.adapter = ExerciseAdapter(data.exercises)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.callService()
    }
}
