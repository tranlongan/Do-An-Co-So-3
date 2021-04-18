package com.example.healthapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.healthapp.R
import com.example.healthapp.databinding.FragmentBrowserBinding


class BrowserFragment : Fragment() {
    private lateinit var adapter: ArrayAdapter<*>
    private var _bingding: FragmentBrowserBinding? = null
    private val binding get() = _bingding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _bingding = FragmentBrowserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.inputSearch.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch()
                return@OnEditorActionListener true
            }
            false
        })

        binding.btnBottomSheetProfile.setOnClickListener {
            findNavController().navigate(R.id.profileDialogFragment)
        }
    }

    private fun performSearch() {
        Toast.makeText(requireContext(), "Yooooooooooo", Toast.LENGTH_SHORT).show()
    }

}