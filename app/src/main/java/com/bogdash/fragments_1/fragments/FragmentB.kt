package com.bogdash.fragments_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.bogdash.fragments_1.R
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
        binding.btnFromBToC.setOnClickListener {
            navigateToFragmentC()
        }

        binding.btnBackToA.setOnClickListener {
            navigateToFragmentA()
        }
    }

    private fun navigateToFragmentC() {
        val fragmentC = FragmentC.newInstance()
        val bundle = Bundle()
        bundle.putString(MESSAGE_KEY, getString(R.string.hello_fragment_c))
        fragmentC.arguments = bundle
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragmentC, FragmentC.FRAGMENT_C_TAG)
            .addToBackStack(FRAGMENT_B_TAG)
            .commit()
    }

    private fun navigateToFragmentA() {
        parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    companion object {
        const val MESSAGE_KEY = "message"
        const val FRAGMENT_B_TAG = "fragmentB"

        fun newInstance() = FragmentB()
    }
}