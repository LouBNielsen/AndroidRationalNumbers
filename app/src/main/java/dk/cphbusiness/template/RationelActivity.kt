package dk.cphbusiness.template

import android.app.Activity
import android.os.Bundle
import dk.cphbusiness.template.model.Numbers.Rational
import dk.cphbusiness.template.model.Numbers.rational
import kotlinx.android.synthetic.main.activity_rationel.*
import org.jetbrains.anko.onClick

class RationelActivity : Activity() {
    var t = Rational(0,1)
    var z = Rational(0,1)
    var y = Rational(0,1)
    var x = Rational(0,1)

    fun update(){
        tField.text = t.text
        zField.text = z.text
        yField.text = y.text
        xField.text = x.text
    }

    fun push(number: Rational){
        t = z
        z = y
        y = x
        x = number
        update()
    }

    fun push(number: Int){
        push(number.rational)
    }

    fun pop() : Rational {
        val r = x
        x = y
        y = z
        z = t
        return r
    }

    fun isNumber(part: String) : Boolean {
        for(digit in part) if (!(digit in '0'..'9')) return false
        return true
    }

    fun plus(){
        val b = pop()
        val a = pop()
        val r = a + b
        push(r)
    }

    fun div(){
        val b = pop()
        val a = pop()
        val r = a/b
        push(r)
    }

    fun minus() {
        val b = pop()
        val a = pop()
        val r = a-b
        push(r)
    }

    fun multiply() {
        val b = pop()
        val a = pop()
        val r = a*b
        push(r)
    }

    fun handle(part: String) {
        when {
            isNumber(part) -> {
                val n = part.toInt()
                push(n)
            }
            part == "+" -> plus()
            part == "/" -> div()
            part == "-" -> minus()
            part == "*" -> multiply()
            else -> xField.text = "ups... $part"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rationel)
        okButton.onClick {
            val parts = inputText.text.split(" ")
            for(part in parts) handle(part)
            inputText.setText("")
        }
        plusBotton.onClick {
            plus()
        }
        minusBotton.onClick {
            minus()
        }
        multiplyBotton.onClick {
            multiply()
        }
        divBotton.onClick {
            div()
        }
        button1.onClick {
            inputText.append("1")
        }
        button2.onClick {
            inputText.append("2")
        }
        button3.onClick {
            inputText.append("3")
        }
        button4.onClick {
            inputText.append("4")
        }
        button5.onClick {
            inputText.append("5")
        }
        button6.onClick {
            inputText.append("6")
        }
        button7.onClick {
            inputText.append("7")
        }
        button8.onClick {
            inputText.append("8")
        }
        button9.onClick {
            inputText.append("9")
        }
    }
}
