package com.adv160420071week2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.adv160420071week2.databinding.FragmentOptionBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class OptionFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentOptionBinding
    private val LEVEL = arrayOf("Easy", "Medium", "Hard")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOptionBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(),
            android.R.layout.simple_dropdown_item_1line, LEVEL)
        binding.txtLevel.setAdapter(adapter)
    }

}