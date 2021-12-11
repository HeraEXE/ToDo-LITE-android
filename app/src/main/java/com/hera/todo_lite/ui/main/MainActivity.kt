package com.hera.todo_lite.ui.main

import androidx.appcompat.widget.Toolbar
import com.hera.todo_lite.R
import com.hera.todo_lite.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun getContentViewId(): Int {
        return R.layout.activity_main
    }

    override fun getToolbar(): Toolbar {
        return findViewById(R.id.toolbar)
    }
}