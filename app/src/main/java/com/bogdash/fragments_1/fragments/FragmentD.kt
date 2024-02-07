package com.bogdash.fragments_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.bogdash.fragments_1.Router
import com.bogdash.fragments_1.databinding.FragmentDBinding

class FragmentD : Fragment(), Router {
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
            showNext()
        }
    }

    override fun showNext() {
        parentFragmentManager.popBackStack(FragmentB.FRAGMENT_B_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
    companion object {
        const val FRAGMENT_D_TAG = "fragmentD"

        fun newInstance() = FragmentD()
    }
}