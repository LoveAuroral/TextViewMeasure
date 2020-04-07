package com.auroral.textviewmeasure

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import auroral.helper.DisplayMetrics

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DisplayMetrics.getDisplayMetrics(this, 720f)
        setContentView(Container(this))
    }
}
