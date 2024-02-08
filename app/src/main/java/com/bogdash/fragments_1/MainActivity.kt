package com.bogdash.fragments_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bogdash.fragments_1.databinding.ActivityMainBinding
import com.bogdash.fragments_1.fragments.FragmentA
import androidx.fragment.app.commit
import com.bogdash.fragments_1.fragments.FragmentB
import com.bogdash.fragments_1.fragments.FragmentC
import com.bogdash.fragments_1.fragments.FragmentD

class MainActivity : AppCompatActivity(), Router {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportFragmentManager.findFragmentByTag(FragmentA.FRAGMENT_A_TAG) == null) {
            supportFragmentManager.commit {
                replace(
                    R.id.fragment_container_view,
                    FragmentA.newInstance(),
                    FragmentA.FRAGMENT_A_TAG
                )
                addToBackStack(FragmentA.FRAGMENT_A_TAG)
            }
        }
    }

    override fun onBackPressed() {
        val stackCount = supportFragmentManager.backStackEntryCount
        if (stackCount == 1) {
            moveTaskToBack(false)
        } else {
            supportFragmentManager.popBackStack()
        }
        return
        super.onBackPressed()
    }

    override fun showNext(fragmentName: String, bundle: Bundle?) {
        val fragment = when (fragmentName) {
            FragmentB.FRAGMENT_B_TAG -> FragmentB.newInstance()
            FragmentC.FRAGMENT_C_TAG -> bundle?.let { FragmentC.newInstance(it) }
            FragmentD.FRAGMENT_D_TAG -> FragmentD.newInstance()

            else -> {
                throw RuntimeException("Фрагмент с таким тегом не найден")
            }
        }

        fragment?.let {
            supportFragmentManager.commit {
                replace(R.id.fragment_container_view, it)
                addToBackStack(fragmentName)
            }
        }
    }

    override fun showPrevious(fragmentName: String) {
        while (supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name != fragmentName) {
            supportFragmentManager.popBackStackImmediate()
        }
    }
}