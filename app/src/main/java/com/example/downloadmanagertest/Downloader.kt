package com.example.downloadmanagertest

interface Downloader {
    fun downloadFile(url: String): Long
}