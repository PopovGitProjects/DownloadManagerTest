package com.example.downloadmanagertest

import android.app.DownloadManager
import android.content.Context
import android.os.Build
import android.os.Environment
import androidx.annotation.RequiresApi
import androidx.core.net.toUri

class AndroidDownloader(private val context: Context): Downloader {
    @RequiresApi(Build.VERSION_CODES.M)
    private val downloadManager = context.getSystemService(DownloadManager::class.java)
    @RequiresApi(Build.VERSION_CODES.M)
    override fun downloadFile(url: String): Long {
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("video/mp4")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
            .setTitle("video.mp4")
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "video.mp4")
        return downloadManager.enqueue(request)
    }
}