package com.ubaya.adv160421039week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubaya.adv160421039week2.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val skor = ResultFragmentArgs.fromBundle(requireArguments()).Score
            binding.txtScore.text = "Your Score is $skor"
        }
        binding.btnBack.setOnClickListener{
            val action = ResultFragmentDirections.actionResultToMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}