package com.bogdash.fragments_1

import android.os.Bundle

interface Router {
    fun showNext(
        fragmentName: String,
        bundle: Bundle? = null
    )

    fun showPrevious(
        fragmentName: String
    )
}