package com.example.downloadmanagertest

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.downloadmanagertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStart() {
        super.onStart()
        addUrl()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun addUrl() = with(binding) {
        val url = edtUrl.text.toString()
        btnDownload.setOnClickListener {
            val downloader = AndroidDownloader(this@MainActivity)
            downloader.downloadFile(url = url)
        }
    }
}