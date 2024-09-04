package com.demo.hntest

import android.app.AlertDialog
import android.content.Context
import android.text.Editable
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

class TestKotlin(context: Context) : AlertDialog(context){
    val name = ""

    fun method1(a:Int, b:Int):Int{

        return a + b
    }

    fun main() {
        method3(1,1,1,1,1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2)
    }


    fun method3(a:Int, b:Int,  c:Int, d:Int, e:Int,
                f:Int, g:Int, h:Int,  i:Int, j:Int,
                        k:Int, l:Int, m:Int, o:Int, p:Int,
                        q:Int, r:Int, s:Int, t:Int, u:Int,
                        v:Int, w:Int, x:Int, y:Int, z:Int,
                        nn:Int, kk:Int, jj:Int, ee:Int, uu:Int):Int{
        return a + b + c + d + e + f + g + h + i + j + k + l + m + o + p + q + r + s + t + u + v + w + x + y + z + nn + kk + jj + ee + uu

    }

    fun meth(block:(a:Int, b:Int) -> String ) {
        val edit: EditText = EditText(context)
        edit.addTextChangedListener(afterTextChanged = {
            block(1, 2)
        })

        edit.addTextChangedListener { it: Editable? ->

        }

    }

    private fun extracted(block: (a: Int, b: Int) -> String) {
        block(1, 3 + 2)
    }


}