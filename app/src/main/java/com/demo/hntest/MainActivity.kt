package com.demo.hntest

import android.app.Activity
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.demo.carsdk.CarManager
import com.demo.hntest.advanced.canvas.MyCanvasView
import com.demo.hntest.ui.theme.HnTestTheme


class MainActivity : Activity() {
   val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("日子日志日志ir日日日i")
        println("网络信号强度  type:$")
//        Log.i(TAG, "onCreate: 网络信号-------" + NetUtil.isWifiApOpen(this))
//        Log.i(TAG, "onCreate: ${NetUtil.getNetWorkType(this)}")

        //使用sdk的方法
        CarManager.getInstance().start()

        val myCanvasView: MyCanvasView

        // No XML file; just one custom view created programmatically.
        myCanvasView = MyCanvasView(this)

        // Request the full available screen for layout.
        myCanvasView.setSystemUiVisibility(SYSTEM_UI_FLAG_FULLSCREEN)
        setContentView(myCanvasView)
    }
}

