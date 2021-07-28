package com.mzhang.videoplayer

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import org.apache.http.conn.ssl.SSLSocketFactory
import java.security.KeyStore
import java.security.SecureRandom
import javax.net.ssl.*

class MainActivity : Activity() {

    /*

    For full screen video view
    *Remove extends Appcompact and use extends activity
    * Add this line in android manifest
     android:theme="@android:style/Theme.NoTitleBar.Fullscreen"

     */
    var videoView: MyVideoView? = null
    var controller: MediaController? = null  //for control video

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val path1 = "https://i.hum.com/media/videos/Hum_Auto_Health.mp4"
        val uri = Uri.parse(path1)

        videoView = findViewById(R.id.videoView)

        //provide url of the video which have extention and not use youtube video link
//        videoView.setVideoPath("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");

//        controller=new MediaController(this);
//        //set controller to videoView
//        videoView.setMediaController(controller);

        //provide url of the video which have extention and not use youtube video link
//        videoView.setVideoPath("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
        controller = MediaController(this)
        videoView?.apply {
            setMediaController(controller)
            setVideoURI(uri)
            requestFocus()
            start()
        }
    }
}
//
//fun VideoView.setVideoURI(uri: Uri) {
////    super.setVideoURI(uri)
//    try {
//        // Let us create the factory where we can set some parameters for the connection
//        var sslContext: SSLContext? = null
//        val trustStore: KeyStore = KeyStore.getInstance(KeyStore.getDefaultType())
//        trustStore.load(null, null)
//        //            trustStore.load(null, null);
//        val trustManagerFactory = TrustManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm())
//        trustManagerFactory.init(null as KeyStore?)
//        sslContext = SSLContext.getInstance("TLSv1.2")
//        sslContext.init(null, trustManagerFactory.trustManagers, SecureRandom())
//
//        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.socketFactory)
//
////        val sf = MySSLSocketFactory(trustStore)
////        sf.setHostnameVerifier(MySSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
////        sf.fixHttpsURLConnection()
//        val hostnameVerifier: HostnameVerifier = SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER
//        HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier)
//    } catch (e: Exception) {
//        e.printStackTrace()
//    }
//}