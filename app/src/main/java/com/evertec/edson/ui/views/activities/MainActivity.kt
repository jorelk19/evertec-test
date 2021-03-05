package com.evertec.edson.ui.views.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.evertec.edson.R
import com.evertec.edson.databinding.ActivityMainBinding
import com.evertec.edson.ui.views.activities.base.BaseFragmentActivity
import com.evertec.edson.ui.views.fragments.MoviesFragment
import com.evertec.utils.ViewManager

class MainActivity : BaseFragmentActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        initControls()
    }

    private fun initControls() {
        ViewManager.getInstance.attachFragment(MoviesFragment(), R.id.fragment_container)
    }
}