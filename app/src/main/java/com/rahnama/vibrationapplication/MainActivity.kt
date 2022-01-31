package com.rahnama.vibrationapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.R
import android.content.Context
import android.os.Build
import android.os.VibrationEffect

import android.os.Vibrator
import com.rahnama.vibrationapplication.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        /*
        این دسترسی جزء مجوزهای خطرناک (Dangerous Permissions) نیست
         بنابراین نیازی به تعریف آن در ران تایم پرمیشن (Runtime Permission) نخواهد بود.
         */
        val mVibrator: Vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

       binding.simpleVibrator.setOnClickListener {
           if (Build.VERSION.SDK_INT >= 26) {

               mVibrator.vibrate(
                   VibrationEffect.createOneShot(
                       300,
                       VibrationEffect.DEFAULT_AMPLITUDE
                   )
               )

           } else {

               mVibrator.vibrate(300);

           }
       }
    }
}