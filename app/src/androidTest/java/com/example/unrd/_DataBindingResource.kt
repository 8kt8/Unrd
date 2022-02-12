package com.example.unrd

import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.withFragment

inline fun <reified T : Fragment> DataBindingIdlingResource.monitorFragment(fragmentScenario: FragmentScenario<T>) {
    fragmentScenario.withFragment {
        this@monitorFragment.activity = this.requireActivity()
    }
}