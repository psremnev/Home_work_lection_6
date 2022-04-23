package com.example.home_work_lection_6

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.home_work_lection_6.databinding.AchievementsItemBinding

class AchievementsAwardsListAdapter(private val ctx: Activity, private val data: ArrayList<Map<String, Any>>):
    RecyclerView.Adapter<AchievementsAwardsListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: AchievementsItemBinding = AchievementsItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: AchievementsItemBinding = AchievementsItemBinding.inflate(inflater)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData: Map<String, Any> = getItemData(position)
        holder.binding.achievement.setImageDrawable(ctx.getDrawable(itemData["photo"] as Int))
        holder.binding.achievementTitle.text = itemData["title"] as String
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun getItemData(position: Int): Map<String, Any> {
        return data[position]
    }
}