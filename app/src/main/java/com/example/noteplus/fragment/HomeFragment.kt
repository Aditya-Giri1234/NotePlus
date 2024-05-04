package com.example.noteplus.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.noteplus.R
import com.example.noteplus.adapter.NoteAdapter
import com.example.noteplus.database.NotesDatabase
import com.example.noteplus.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding

    companion object{
        @JvmStatic
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding=FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvNotes.setHasFixedSize(false)
        binding.rvNotes.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        CoroutineScope(Dispatchers.IO).launch {
        context?.let {
            val notes = NotesDatabase.getDatabase(it).getDao().getAllNotes()
            withContext(Dispatchers.Main){
                binding.rvNotes.adapter=NoteAdapter(notes)
            }

        }
        }

        binding.btnAdd.setOnClickListener{
replaceFragment(CreateNoteFragment.newInstance(),true)
        }
    }
    private fun replaceFragment(fragment: Fragment, isTransition:Boolean){
        val fragmentTransition=requireActivity().supportFragmentManager.beginTransaction()
        if(isTransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
        }

        fragmentTransition.replace(R.id.frameLayout,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }

}