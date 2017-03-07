package dk.cphbusiness.template

import android.app.Activity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = "Hello from Kotlin"
        button1.onClick { toast("Button 1 was clicked") }
        }

    fun button2Clicked(view: View) {
        message.text = "Button 2 was clicked"
        }

    }
