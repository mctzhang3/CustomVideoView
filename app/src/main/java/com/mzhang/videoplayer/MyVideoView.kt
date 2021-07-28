package com.mzhang.videoplayer

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.widget.VideoView
import com.mzhang.videoplayer.SSlUtiles.TrustAllHostnameVerifier
import javax.net.ssl.HttpsURLConnection

class MyVideoView : VideoView {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
    }

    override fun setVideoURI(uri: Uri) {
        super.setVideoURI(uri)
        try {
            HttpsURLConnection.setDefaultSSLSocketFactory(SSlUtiles.createSSLSocketFactory())
            HttpsURLConnection.setDefaultHostnameVerifier(TrustAllHostnameVerifier())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}