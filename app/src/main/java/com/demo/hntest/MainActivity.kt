package com.demo.hntest

import android.os.Bundle
import android.util.Log
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
import com.demo.hntest.ui.theme.HnTestTheme
import com.demo.hntest.utils.NetUtil

class MainActivity : ComponentActivity() {
   val TAG: String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("日子日志日志ir日日日i")
        println("网络信号强度  type:$")
        Log.i(TAG, "onCreate: 网络信号-------" + NetUtil.isWifiApOpen(this))
        Log.i(TAG, "onCreate: ${NetUtil.getNetWorkType(this)}")
        enableEdgeToEdge()
        setContent {
            HnTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
            NetUtil.getNetWorkWifiLevel(this)
            var  type =  NetUtil.getNetWorkType(this)
            println("网络信号强度  type:$type")
        }


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HnTestTheme {
        Greeting("Android")
    }
}