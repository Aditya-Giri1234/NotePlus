package com.example.noteplus.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.noteplus.Entity.Notes
import com.example.noteplus.R
import com.example.noteplus.database.NotesDatabase
import com.example.noteplus.databinding.FragmentCreateNoteBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date


class CreateNoteFragment : BaseFragment() {
    private lateinit var binding: FragmentCreateNoteBinding
    private lateinit var date:String
    private var selectedColor="#171C26"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding=FragmentCreateNoteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sdf=SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    date=sdf.format(Date())
binding.tvDateTime.text=date

        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(broadcastReceiver,
            IntentFilter("bottom_sheet_action")
        )

        binding.ivCheck.setOnClickListener{
            saveNote()
        }
        binding.ivBack.setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }

        binding.imgNote.setOnClickListener{
            val myBottomSheet=MyBottomSheet.getInstance()
            myBottomSheet.show(requireActivity().supportFragmentManager,"Note Bottom Sheet Fragment")
        }

    }
    private fun replaceFragment(fragment: Fragment, isTransition:Boolean){
        val fragmentTransition=requireActivity().supportFragmentManager.beginTransaction()
        if(isTransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }

        fragmentTransition.replace(R.id.frameLayout,fragment).addToBackStack(fragment.javaClass.name).commit()
    }
    private fun saveNote() {
        if(binding.etNoteTitle.text.isNullOrEmpty()){
            Toast.makeText(requireContext(),"Note title required !",Toast.LENGTH_SHORT).show()
        }
        if(binding.etNoteSubTitle.text.isNullOrEmpty()){
            Toast.makeText(requireContext(),"Note Sub title required !",Toast.LENGTH_SHORT).show()
        }
        if(binding.etNoteDescription.text.isNullOrEmpty()){
            Toast.makeText(requireContext(),"Note Description required !",Toast.LENGTH_SHORT).show()
        }

        launch {
            val note=Notes()
            note.title=binding.etNoteTitle.text.toString()
            note.subTitle=binding.etNoteSubTitle.text.toString()
            note.noteText=binding.etNoteDescription.text.toString()
            note.dateTime=date
            note.color=selectedColor

            context?.let {
                NotesDatabase.getDatabase(it).getDao().insertNote(note)
                binding.etNoteSubTitle.setText("")
                binding.etNoteTitle.setText("")
                binding.etNoteDescription.setText("")
                delay(100)
                Toast.makeText(it,"Note Saved Successfully !",Toast.LENGTH_SHORT).show()
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

    }


    companion object{
        @JvmStatic
        fun newInstance(): CreateNoteFragment {
            return CreateNoteFragment()
        }
    }

    private  val broadcastReceiver:BroadcastReceiver=object :BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            val actionColor=p1!!.getStringExtra("actionColor")

            when(actionColor){
                "Blue"->{
                    selectedColor=p1.getStringExtra("selectedColor")!!
                    binding.colorView.setBackgroundColor(Color.parseColor(selectedColor))
                }
                "Yellow"->{
                    selectedColor=p1.getStringExtra("selectedColor")!!
                    binding.colorView.setBackgroundColor(Color.parseColor(selectedColor))

                }
                "White"->{
                    selectedColor=p1.getStringExtra("selectedColor")!!
                    binding.colorView.setBackgroundColor(Color.parseColor(selectedColor))
                }
                "Purple"->{
                    selectedColor=p1.getStringExtra("selectedColor")!!
                    binding.colorView.setBackgroundColor(Color.parseColor(selectedColor))
            }
                "Green"->{
                    selectedColor=p1.getStringExtra("selectedColor")!!
                    binding.colorView.setBackgroundColor(Color.parseColor(selectedColor))
            }
                "Orange"->{
                    selectedColor=p1.getStringExtra("selectedColor")!!
                    binding.colorView.setBackgroundColor(Color.parseColor(selectedColor))
            }
                "Black"->{
                    selectedColor=p1.getStringExtra("selectedColor")!!
                    binding.colorView.setBackgroundColor(Color.parseColor(selectedColor))
            }
            }
        }

    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(broadcastReceiver)
        super.onDestroy()
    }

}