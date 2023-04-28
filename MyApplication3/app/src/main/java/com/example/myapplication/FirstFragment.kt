package com.example.myapplication

import android.content.ClipData.Item
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = mutableListOf<ItemData>()
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this.context)

        data.add(ItemData("On our knees", "KONOBA", R.drawable.konoba, this.resources.getString(R.string.konoba_description)))
        data.add(ItemData("Mockingbird", "Eminem", R.drawable.mockingbird, this.resources.getString(R.string.mockingbird_description)))
        data.add(ItemData("Back from the dead", "Besomorph", R.drawable.backfromthedead, this.resources.getString(R.string.backfromthedead_description)))


        recyclerView.adapter = ItemDataAdapter(data, this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}