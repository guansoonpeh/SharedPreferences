package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferences.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedpreferences:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        sharedpreferences = getSharedPreferences(R.string.app_name.toString(), Context.MODE_PRIVATE);
        //  sharedpreferences = getPreferences(Context.MODE_PRIVATE);

        setContentView(binding.root)

        binding.btnSet.setOnClickListener(){
            val editor = sharedpreferences.edit()

            editor.putString("myData", "A12345")
            editor.commit()
        }

        binding.btnGet.setOnClickListener(){

            val value = sharedpreferences.getString("myData", "")

            binding.textView.text = value

        }

        binding.btnNextActivity.setOnClickListener(){
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}