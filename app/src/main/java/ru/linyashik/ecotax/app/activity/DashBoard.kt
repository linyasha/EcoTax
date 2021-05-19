package ru.linyashik.ecotax.app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.linyashik.ecotax.R

class DashBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)
    }
}