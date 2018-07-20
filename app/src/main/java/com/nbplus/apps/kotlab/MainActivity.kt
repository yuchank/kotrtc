package com.nbplus.apps.kotlab

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import org.webrtc.*

class MainActivity : AppCompatActivity(), View.OnClickListener, SignalingClient.SignalingInterface {
  private val rootEglBase by lazy { EglBase.create() }

  private var localVideoView: SurfaceViewRenderer? = null
  private var remoteVideoView: SurfaceViewRenderer? = null

  private var hangup: Button? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    initViews()
    initVideos()
    getIceServers()
    SignalingClient.init(this)
    start()
  }

  private fun initViews() {
    hangup = findViewById(R.id.end_call)
    localVideoView = findViewById(R.id.local_gl_surface_view)
    remoteVideoView = findViewById(R.id.remote_gl_surface_view)
    hangup?.setOnClickListener(this)
  }

  private fun initVideos() {
    localVideoView?.init(rootEglBase.eglBaseContext, null)
    remoteVideoView?.init(rootEglBase.eglBaseContext, null)
    localVideoView?.setZOrderMediaOverlay(true)
    remoteVideoView?.setZOrderMediaOverlay(true)
  }

  private fun getIceServers() {
    // get Ice servers using xirsys

  }

  private fun start() {
    val videoCapturerAndroid: VideoCapturer? = createCameraCapturer(Camera1Enumerator(false))
  }

  /**
   * Closing up - normal hangup and app destroy
   */
  override fun onClick(v: View?) {
    when (v?.id) {
      R.id.end_call -> hangup()
    }
  }

  private fun hangup() {

  }

  override fun onDestroy() {
    SignalingClient.close()
    super.onDestroy()
  }

  private fun createCameraCapturer(enumerator: CameraEnumerator): VideoCapturer? {
    val deviceNames = enumerator.deviceNames
    // find the front facing camera and return it
    deviceNames.filter{ enumerator.isFrontFacing(it) }
    return null
  }

}
