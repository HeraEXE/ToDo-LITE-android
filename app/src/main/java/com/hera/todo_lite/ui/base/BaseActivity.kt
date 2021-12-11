package com.hera.todo_lite.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(getContentViewId())
        setSupportActionBar(getToolbar())
    }

    abstract fun getContentViewId(): Int

    abstract fun getToolbar(): Toolbar
}