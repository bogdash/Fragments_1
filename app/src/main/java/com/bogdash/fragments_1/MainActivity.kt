package com.bogdash.fragments_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bogdash.fragments_1.databinding.ActivityMainBinding
import com.bogdash.fragments_1.fragments.FragmentA

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view, FragmentA.newInstance(), FragmentA.FRAGMENT_A_TAG)
            .commit()
    }

}