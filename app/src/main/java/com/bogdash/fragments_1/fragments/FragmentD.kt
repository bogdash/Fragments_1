package com.bogdash.fragments_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bogdash.fragments_1.MainActivity
import com.bogdash.fragments_1.databinding.FragmentDBinding

class FragmentD : Fragment() {
    private lateinit var binding: FragmentDBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFromDToB.setOnClickListener {
            (requireActivity() as MainActivity).showPrevious(FragmentB.FRAGMENT_B_TAG)
        }
    }

    companion object {
        const val FRAGMENT_D_TAG = "fragmentD"

        fun newInstance() = FragmentD()
    }
}