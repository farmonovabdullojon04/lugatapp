package com.abdullojon.lugatapp.fragments

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdullojon.lugatapp.R
import com.abdullojon.lugatapp.adapter.DictionaryAdapter
import com.abdullojon.lugatapp.data.MyDatabase
import com.abdullojon.lugatapp.databinding.FragmentMainBinding
import java.util.Locale

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val database by lazy { MyDatabase.getInstance() }
    private val adapter = DictionaryAdapter()

    private var tts: TextToSpeech? = null
    private var currentQuery: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        tts = TextToSpeech(requireContext()) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts?.language = Locale.ENGLISH
            }
        }

        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter

        adapter.SetListenerSpec { wordText ->
            tts?.speak(wordText, TextToSpeech.QUEUE_FLUSH, null, null)
        }

        adapter.setOnItemClickListener { word ->
            val bundle = Bundle().apply {
                putInt("wordId", word.id)
            }
            findNavController().navigate(
                R.id.action_mainFragment_to_detailFragment,
                bundle
            )
        }

        adapter.setOnBookmarkClickListener { word ->
            val newFavState = if (word.isFavourite == 1) 0 else 1
            database.getDictionaryDao().updateFavourite(word.id, newFavState)
            loadData()
        }

        loadData()

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = true

            override fun onQueryTextChange(newText: String?): Boolean {
                currentQuery = newText ?: ""
                loadData()
                return true
            }
        })
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData() {
        val dao = database.getDictionaryDao()
        val list = if (currentQuery.isBlank()) {
            dao.getAll()
        } else {
            dao.getAllBySearch(currentQuery)
        }
        adapter.submitList(list, currentQuery)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        tts?.stop()
        tts?.shutdown()
        tts = null
    }
}