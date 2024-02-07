package com.bogdash.fragments_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.bogdash.fragments_1.R
import com.bogdash.fragments_1.Router
import com.bogdash.fragments_1.databinding.FragmentCBinding

class FragmentC : Fragment(), Router {
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

        message?.let {
            binding.tvFragmentC.text = it
        }

        binding.btnFromCToD.setOnClickListener {
            showNext()
        }

        binding.btnFromCToA.setOnClickListener {
            showPrevious()
        }
    }

    override fun showPrevious() {
        parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun showNext() {
        val fragmentD = FragmentD.newInstance()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragmentD, FragmentD.FRAGMENT_D_TAG)
            .addToBackStack(FRAGMENT_C_TAG)
            .commit()
    }

    companion object {
        const val MESSAGE_KEY = "message"
        const val FRAGMENT_C_TAG = "fragmentC"

        fun newInstance() = FragmentC()
    }

}