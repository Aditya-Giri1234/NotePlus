package com.example.noteplus.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.noteplus.R
import com.example.noteplus.databinding.ActivityMainBinding
import com.example.noteplus.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment.newInstance(),true)
    }

    fun replaceFragment(fragment: Fragment, isTransition:Boolean){
        val fragmentTransition=supportFragmentManager.beginTransaction()
        if(isTransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }

        fragmentTransition.replace(R.id.frameLayout,fragment).addToBackStack(fragment.javaClass.name).commit()
    }
}