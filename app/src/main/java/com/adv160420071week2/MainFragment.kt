package com.adv160420071week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.adv160420071week2.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun changeNumber(): Int {
        var rnds1 = (0..50).random()
        var rnds2 = (0..50).random()
        binding.txtNumber.setText("$rnds1 + $rnds2")
        return rnds1 + rnds2
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var hasil = changeNumber()
        var playerScore = 0
        binding.btnStart.setOnClickListener {
            val playerAnswer = binding.txtAnswer.text.toString()
            if (playerAnswer != ""){
                if (playerAnswer.toInt() == hasil){
                    playerScore++
                    hasil = changeNumber()
                    binding.txtAnswer.setText("")
                } else {
                    val action = MainFragmentDirections.actionGameFragment(playerScore.toString())
                    Navigation.findNavController(it).navigate(action)
                }
            } else {
                val action = MainFragmentDirections.actionGameFragment(playerScore.toString())
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}