package com.bitcode.yourapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import com.bitcode.yourapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var builder = StrictMode.VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowImage.setOnClickListener {
            //var intent = Intent(this, ImageActivity::class.java)

            var intent = Intent("in.bitcode.media.VIEW")
            intent.action = "in.bitcode.media.VIEW"
            intent.addCategory("in.bitcode.category.GENERAL")

            //intent.putExtra("path", binding.edtPath.text.toString())
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/png"
            )
            startActivity(intent)
        }

        binding.btnShowInGal.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/png"
            )
            startActivity(intent)
        }

        binding.btnAudio.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "audio/mp3"
            )
            startActivity(intent)
        }
        binding.btnVideo.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "video/mp4"
            )
            startActivity(intent)
        }

        binding.btnWeb.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(
                Uri.parse(binding.edtPath.text.toString()),
            )
            startActivity(intent)
        }

        binding.btnShare.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/*"
            )
            startActivity(intent)
        }

        binding.btnCall.setOnClickListener {
            //var intent = Intent(Intent.ACTION_DIAL)
            var intent = Intent(Intent.ACTION_CALL)
            intent.setData(
                Uri.parse(binding.edtPath.text.toString())
            )
            startActivity(intent)
        }
    }
}