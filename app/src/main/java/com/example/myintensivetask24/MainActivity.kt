package com.example.myintensivetask24

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myintensivetask24.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var conter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {
            btn.setOnClickListener {
                conter++
                tv.text = conter.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val saveNumber = conter
        outState.putInt(COUNTER_SAVE, conter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val counterInt = savedInstanceState.getInt(COUNTER_SAVE, 0)
        conter = counterInt
        binding.tv.text = conter.toString()
    }

    companion object {
        const val COUNTER_SAVE = "COUNTER_SAVE"
    }
}