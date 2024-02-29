package com.example.navigation_week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigation_week2.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding:FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
//        return inflater.inflate(R.layout.fragment_main, container, false)
        return binding.root
    }

    //tempat mengakses layout/ui (seperti tombol dll)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnStart.setOnClickListener{
            //MainFragmentDirection class otomatis dibuat android studio
            var namePlayer = binding.txtName.text.toString()
            val action = MainFragmentDirections.actionGameFragment(namePlayer)
            //memerintahkan nav controller untuk mencari controllernya dan
            //akan navigate ke actionnya, jika tombol ditekan maka fragment akan di replace ke game fragment
            Navigation.findNavController(it).navigate(action)

        }
    }

}