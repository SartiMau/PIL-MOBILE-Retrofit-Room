package com.pil.retrofit_room.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pil.retrofit_room.R
import com.pil.retrofit_room.databinding.ItemRecyclerBinding
import com.pil.retrofit_room.service.model.Exercise

class ExerciseAdapter(private val exercises: List<Exercise>) : RecyclerView.Adapter<ExerciseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(exercises[position])
    }

    override fun getItemCount(): Int = exercises.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRecyclerBinding.bind(itemView)

        fun bind(exercise: Exercise) {
            binding.id.text = itemView.context.getString(R.string.card_id, exercise.id.toString())
            binding.isMain.text = itemView.context.getString(R.string.card_is_main, exercise.isMain.toString())
            binding.status.text = itemView.context.getString(R.string.card_status, exercise.status)

            Glide.with(itemView.context)
                .load(exercise.image)
                .into(binding.image)
        }
    }
}
