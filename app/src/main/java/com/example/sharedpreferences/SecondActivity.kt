package com.example.sharedpreferences

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivitySecondBinding
import java.util.prefs.Preferences

class SecondActivity : AppCompatActivity() {
    lateinit var binding : ActivitySecondBinding
    private lateinit var sharedpreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)

        sharedpreferences = getSharedPreferences(R.string.app_name.toString(), Context.MODE_PRIVATE);
        //sharedpreferences = getPreferences(Context.MODE_PRIVATE)


        setContentView(binding.root)

        binding.btnGet2.setOnClickListener(){

            val value = sharedpreferences.getString("myData", "")

            binding.tvResult.text = value

        }

    }
}