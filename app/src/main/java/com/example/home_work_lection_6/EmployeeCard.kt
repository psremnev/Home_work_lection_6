package com.example.home_work_lection_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.home_work_lection_6.databinding.FragmentEmployeeCardBinding

enum class STATUS(val value: String) {
    IN("В сети"),
    OUT("Не в сети")
}

class EmployeeCard : Fragment() {

    private val binding: FragmentEmployeeCardBinding by lazy { FragmentEmployeeCardBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        // вычисялем данные по сотруднику и устанавливаем их в биндинг
        val data = arguments?.getInt("id")?.let { getCardData(it) }
        binding.employee = data

        // инициализируем адаптер списка наград
        data?.achievementsAwards?.let { initAchievementAdapter(it) }

        // устанвливаем данные для разных View
        binding.statusIon.background = if (data?.status == STATUS.IN.value) {
            activity?.getDrawable(R.drawable.status_in)
        } else {
            activity?.getDrawable(R.drawable.status_out)
        }
        binding.photoCard.setImageDrawable(data?.photo?.let { activity?.getDrawable(it) })

        // устанвливаем коллбеки на события
        binding.phoneCall.setOnClickListener {
            Toast.makeText(activity,"Вызываем сотрудника ${data?.fio}", Toast.LENGTH_SHORT).show()
        }

        binding.message.setOnClickListener {
            Toast.makeText(activity, "Посылаем сообщение для ${data?.fio}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initAchievementAdapter(data: ArrayList<Map<String, Any>>) {
        binding.achievementsAwardsList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.achievementsAwardsList.adapter =
            activity?.let { AchievementsAwardsListAdapter(it, data) }
    }
}