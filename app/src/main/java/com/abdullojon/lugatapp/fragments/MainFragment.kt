package com.abdullojon.lugatapp.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdullojon.lugatapp.R
import com.abdullojon.lugatapp.adapter.DictionaryAdapter
import com.abdullojon.lugatapp.data.MyDatabase
import com.abdullojon.lugatapp.databinding.FragmentMainBinding
import java.util.Locale


class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val database = MyDatabase.getInstance()
    private val adapter = DictionaryAdapter()

    private val handler by lazy { Handler(Looper.getMainLooper()) }

    private lateinit var tts: TextToSpeech

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentMainBinding.bind(view)

        tts= TextToSpeech(requireContext()){
            if (it==TextToSpeech.SUCCESS){
                tts.language= Locale.ENGLISH
            }
        }

        val dictionaryDao = database.getDictionaryDao()

        val list = dictionaryDao.getAll()
        Log.d("TTT", "listsize${list.size}")

        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter
        adapter.submitList(list,"")

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText==null){
                    adapter.submitList(dictionaryDao.getAll(),"")
                }else{
                    handler.postDelayed({
                        adapter.submitList(dictionaryDao.getAllBySearch(newText),newText)
                    },2000)
                }
                return true

            }
        })
        adapter.SetListenerSpec {
            tts.speak(it, TextToSpeech.QUEUE_FLUSH,null,null)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        tts.stop()
        tts.shutdown()
    }
}