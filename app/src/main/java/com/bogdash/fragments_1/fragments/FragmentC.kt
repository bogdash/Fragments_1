package com.bogdash.fragments_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bogdash.fragments_1.MainActivity
import com.bogdash.fragments_1.databinding.FragmentCBinding

class FragmentC : Fragment() {
    private lateinit var binding: FragmentCBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val message = arguments?.getString(MESSAGE_KEY)

        with(binding) {
            message?.let {
                tvFragmentC.text = it
            }

            btnFromCToD.setOnClickListener {
                (requireActivity() as MainActivity).showNext(FragmentD.FRAGMENT_D_TAG)
            }

            btnFromCToA.setOnClickListener {
                (requireActivity() as MainActivity).showPrevious(FragmentA.FRAGMENT_A_TAG)
            }
        }
    }

    companion object {
        const val MESSAGE_KEY = "message"
        const val FRAGMENT_C_TAG = "fragmentC"

        fun newInstance(bundle: Bundle) = FragmentC().apply {
            arguments = bundle
        }
    }

}