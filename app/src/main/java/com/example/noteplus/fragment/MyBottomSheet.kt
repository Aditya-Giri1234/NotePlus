package com.example.noteplus.fragment

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.noteplus.R
import com.example.noteplus.databinding.NoteBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MyBottomSheet : BottomSheetDialogFragment() {
    private var selectedColor="#171C26"
    private lateinit var binding:NoteBottomSheetBinding


    companion object{
        fun getInstance():MyBottomSheet{
            val args=Bundle()
            val fragment=MyBottomSheet()
            fragment.arguments=args
            return fragment
        }
    }


    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        val view=LayoutInflater.from(context).inflate(R.layout.note_bottom_sheet,null)
        dialog.setContentView(view)
        val param=(view.parent as View).layoutParams as CoordinatorLayout.LayoutParams
        val behavior=param.behavior

        if(behavior is BottomSheetBehavior<*>){
            behavior.setBottomSheetCallback(object :BottomSheetBehavior.BottomSheetCallback(){
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    var state=""
                    when(newState){
                        BottomSheetBehavior.STATE_DRAGGING->{
                            state="DRAGGING"
                        }
                        BottomSheetBehavior.STATE_SETTLING->{
                            state="SETTLING"
                        }
                        BottomSheetBehavior.STATE_EXPANDED->{
                            state="EXPANDED"
                        }
                        BottomSheetBehavior.STATE_COLLAPSED->{
                            state="COLLAPSED"
                        }
                        BottomSheetBehavior.STATE_HIDDEN->{
                            state="HIDDEN"
                            dismiss()
                            behavior.state=BottomSheetBehavior.STATE_COLLAPSED
                        }

                    }

                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                }

            })
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=NoteBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener(){


        binding.fNote1.setOnClickListener{

            binding.imgNote1.setImageResource(R.drawable.iv_only_check)
            binding.imgNote2.setImageResource(0)
            binding.imgNote3.setImageResource(0)
            binding.imgNote4.setImageResource(0)
            binding.imgNote5.setImageResource(0)
            binding.imgNote6.setImageResource(0)
            binding.imgNote7.setImageResource(0)
            selectedColor="#4e33ff"
            val intent= Intent("bottom_sheet_action")
            intent.putExtra("actionColor","Blue")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }
       binding.fNote2.setOnClickListener{
           binding.imgNote1.setImageResource(0)
           binding.imgNote2.setImageResource(R.drawable.iv_only_check)
           binding.imgNote3.setImageResource(0)
           binding.imgNote4.setImageResource(0)
           binding.imgNote5.setImageResource(0)
           binding.imgNote6.setImageResource(0)
           binding.imgNote7.setImageResource(0)
           selectedColor="#ffd633"
            val intent= Intent("bottom_sheet_action")
            intent.putExtra("actionColor","Yellow")
           intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }
        binding.fNote3.setOnClickListener{
            binding.imgNote1.setImageResource(0)
            binding.imgNote2.setImageResource(0)
            binding.imgNote3.setImageResource(R.drawable.iv_only_check)
            binding.imgNote4.setImageResource(0)
            binding.imgNote5.setImageResource(0)
            binding.imgNote6.setImageResource(0)
            binding.imgNote7.setImageResource(0)
            selectedColor="#ffffff"
            val intent= Intent("bottom_sheet_action")
            intent.putExtra("actionColor","White")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }

        binding.fNote4.setOnClickListener{
            binding.imgNote1.setImageResource(0)
            binding.imgNote2.setImageResource(0)
            binding.imgNote3.setImageResource(0)
            binding.imgNote4.setImageResource(R.drawable.iv_only_check)
            binding.imgNote5.setImageResource(0)
            binding.imgNote6.setImageResource(0)
            binding.imgNote7.setImageResource(0)
            selectedColor="#ae3b76"
            val intent= Intent("bottom_sheet_action")
            intent.putExtra("actionColor","Purple")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }
        binding.fNote5.setOnClickListener{
            binding.imgNote1.setImageResource(0)
            binding.imgNote2.setImageResource(0)
            binding.imgNote3.setImageResource(0)
            binding.imgNote4.setImageResource(0)
            binding.imgNote5.setImageResource(R.drawable.iv_only_check)
            binding.imgNote6.setImageResource(0)
            binding.imgNote7.setImageResource(0)
            selectedColor="#0aebaf"
            val intent= Intent("bottom_sheet_action")
            intent.putExtra("actionColor","Green")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }
        binding.fNote6.setOnClickListener{
            binding.imgNote1.setImageResource(0)
            binding.imgNote2.setImageResource(0)
            binding.imgNote3.setImageResource(0)
            binding.imgNote4.setImageResource(0)
            binding.imgNote5.setImageResource(0)
            binding.imgNote6.setImageResource(R.drawable.iv_only_check)
            binding.imgNote7.setImageResource(0)
            selectedColor="#ff7746"
            val intent= Intent("bottom_sheet_action")
            intent.putExtra("actionColor","Orange")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }
        binding.fNote7.setOnClickListener{
            binding.imgNote1.setImageResource(0)
            binding.imgNote2.setImageResource(0)
            binding.imgNote3.setImageResource(0)
            binding.imgNote4.setImageResource(0)
            binding.imgNote5.setImageResource(0)
            binding.imgNote6.setImageResource(0)
            binding.imgNote7.setImageResource(R.drawable.iv_only_check)
            selectedColor="#202734"
            val intent= Intent("bottom_sheet_action")
            intent.putExtra("actionColor","Black")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }


    }

//    override fun getTheme(): Int {
//        return R.style.Theme_Bottom
//    }
}