package com.bogdash.fragments_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bogdash.fragments_1.MainActivity
import com.bogdash.fragments_1.databinding.FragmentABinding

class FragmentA : Fragment() {
    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentABinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnFromAToB.setOnClickListener {
            (requireActivity() as MainActivity).showNext(FragmentB.FRAGMENT_B_TAG)
        }
    }

    companion object {
        const val FRAGMENT_A_TAG = "fragmentA"
        fun newInstance() = FragmentA()
    }

}