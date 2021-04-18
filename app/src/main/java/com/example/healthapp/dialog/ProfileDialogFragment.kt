package com.example.healthapp.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.healthapp.R
import com.example.healthapp.databinding.LayoutBottomSheetProfileBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ProfileDialogFragment : BottomSheetDialogFragment() {
    private var _binding: LayoutBottomSheetProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LayoutBottomSheetProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireView().viewTreeObserver.addOnGlobalLayoutListener {
            val dialog = dialog as? BottomSheetDialog
            val bottomSheet =
                dialog?.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)
//            bottomSheet?.top
            val height = (requireContext().resources.displayMetrics.heightPixels * 0.96).toInt()
            println(height)
            bottomSheet?.let {
                BottomSheetBehavior.from<FrameLayout>(bottomSheet).apply {
                    isDraggable = true
                    state = BottomSheetBehavior.STATE_COLLAPSED
                    setPeekHeight(height, true)
                    this.expandedOffset = 1
                    this.isHideable = false
                }
            }
        }
    }

    override fun getTheme() = R.style.CustomBottomSheetDialog
}