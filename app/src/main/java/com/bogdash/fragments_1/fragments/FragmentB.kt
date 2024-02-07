package com.bogdash.fragments_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bogdash.fragments_1.MainActivity
import com.bogdash.fragments_1.databinding.FragmentBBinding

class FragmentB : Fragment() {
    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnFromBToC.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(MESSAGE_KEY, STRING_FOR_FRAGMENT_C)
                (requireActivity() as MainActivity).showNext(FragmentC.FRAGMENT_C_TAG, bundle)
            }

            btnBackToA.setOnClickListener {
                (requireActivity() as MainActivity).showPrevious(FragmentA.FRAGMENT_A_TAG)
            }
        }
    }


    companion object {
        const val STRING_FOR_FRAGMENT_C = "Hello, Fragment C!"
        const val MESSAGE_KEY = "message"
        const val FRAGMENT_B_TAG = "fragmentB"

        fun newInstance() = FragmentB()
    }
}