package com.evertec.edson.ui.views.activities.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavHost
import com.evertec.utils.ViewManager

/**
 * Class used to manage the activities in the application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
open class BaseFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        ViewManager.getInstance.setCurrentActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewManager.getInstance.setCurrentActivity(this)
    }

    override fun onResume() {
        super.onResume()
        ViewManager.getInstance.setCurrentActivity(this)
    }

    override fun onBackPressed() {
        ViewManager.getInstance.onBack()
    }

}