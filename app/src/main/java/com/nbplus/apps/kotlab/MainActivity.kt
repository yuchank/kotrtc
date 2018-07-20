package com.nbplus.apps.kotlab

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener, SignalingClient.SignalingInterface {

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

  }

  private fun initVideos() {

  }

  private fun getIceServers() {

  }

  private fun start() {

  }

  /**
   * Closing up - normal hangup and app destroy
   */
  override fun onClick(v: View?) {
    when (v?.id) {
    }
  }

}
