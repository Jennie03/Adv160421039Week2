package com.ubaya.adv160421039week2

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubaya.adv160421039week2.databinding.ActivityMainBinding
import com.ubaya.adv160421039week2.databinding.FragmentMainBinding
import kotlin.random.Random

class MainFragment : Fragment()
{
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.btnStart.setOnClickListener{
//            val playerName = binding.txtName.text.toString()
//            val action = MainFragmentDirections.actionGameFragment(playerName)
//            Navigation.findNavController(it).navigate(action)
//        }
        var num1 = Random.nextInt(1, 100)
        var num2 = Random.nextInt(1, 100)
        binding.txtQuestion.text = "$num1 + $num2"
        var skor = 0
        binding.btnSubmit.setOnClickListener{
            val result = (num1 + num2)
            val input = binding.txtAnswer.text.toString().toInt()
            if (result == input.toInt()) {
                val dialog = AlertDialog.Builder(activity)
                dialog.setTitle("Informasi")
                skor++
                dialog.setMessage("Jawaban anda benar!\nSkor anda saat ini: $skor")
                dialog.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                    binding.txtAnswer.text?.clear()
                    var num1 = Random.nextInt(1, 100)
                    var num2 = Random.nextInt(1, 100)
                    binding.txtQuestion.text = "$num1 + $num2"
                })
                dialog.create().show()
            }
            else {
                val result = MainFragmentDirections.actionResultFragment(skor.toString())
                Navigation.findNavController(it).navigate(result)
                skor = 0
            }
        }
    }
}