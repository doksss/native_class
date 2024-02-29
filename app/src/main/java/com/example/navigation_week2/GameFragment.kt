package com.example.navigation_week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigation_week2.databinding.FragmentGameBinding
import com.example.navigation_week2.databinding.FragmentMainBinding
import kotlin.random.Random


class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(inflater, container, false)
//        return inflater.inflate(R.layout.fragment_game, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null){
            val name = GameFragmentArgs.fromBundle(requireArguments()).namePlayer
            binding.txtTurn.text = "$name's turn"
            var angka1 = Random.nextInt(100)
            var angka2 = Random.nextInt(100)
            binding.txtQuestion.text = angka1.toString() + " + " + angka2.toString()
            var point = 0

            binding.btnSubmit.setOnClickListener{
                var hasil = angka1 + angka2
                var inputUser = binding.txtAnswer.text.toString()
                if(hasil == inputUser.toInt()){
                    point++
                    angka1 = Random.nextInt(100)
                    angka2 = Random.nextInt(100)
                    binding.txtAnswer.setText("")
                    binding.txtQuestion.text = angka1.toString() + " + " + angka2.toString()
                }else{
                    val action = GameFragmentDirections.actionResultFragment(point)
                    Navigation.findNavController(it).navigate(action)
                }
            }

        }
    }
}