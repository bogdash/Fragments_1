package com.bogdash.fragments_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bogdash.fragments_1.R
import com.bogdash.fragments_1.Router
import com.bogdash.fragments_1.databinding.FragmentABinding

class FragmentA : Fragment(), Router {
    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnFromAToB.setOnClickListener{
            showNext()
        }
    }

    override fun showNext() {
        val fragmentB = FragmentB.newInstance()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragmentB, FragmentB.FRAGMENT_B_TAG)
            .addToBackStack(FRAGMENT_A_TAG)
            .commit()
    }

    companion object {
        const val FRAGMENT_A_TAG = "fragmentA"
        fun newInstance() = FragmentA()
    }

}