package com.example.home_work_lection_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.home_work_lection_6.databinding.FragmentMainBinding

class Main : Fragment() {
    private val binding: FragmentMainBinding by lazy { FragmentMainBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        // Инициализируем адаптер списка
        val data = getListData()
        val from: Array<String> = arrayOf("photo", "name")
        val toView: IntArray = intArrayOf(R.id.photo, R.id.name)
        binding.employeeList.adapter = SimpleAdapter(activity, data, R.layout.list_item, from, toView)

        // Устанавливаем коллбек события клика
        binding.employeeList.onItemClickListener = AdapterView.OnItemClickListener { p0, p1, p2, p3 ->
            val params = Bundle()
            params.putInt("id", p2)
            findNavController().navigate(R.id.action_main_to_employeeCard, params)
        }
    }
}