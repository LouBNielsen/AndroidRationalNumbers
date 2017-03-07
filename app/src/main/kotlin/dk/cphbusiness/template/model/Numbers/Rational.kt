package dk.cphbusiness.template.model.Numbers

import android.support.v7.appcompat.R

/**
 * Created by LouiseB on 21-02-2017.
 */

data class Rational(val n: Int, val d: Int){

    private fun gcd(a: Int, b: Int) : Int {
        if (b == 0) return a
        else return gcd(b,a%b)
    }

    val text: String
    get() = "${n/gcd}/${d/gcd}"

    val gcd: Int by lazy {
        println("Calculating gcd")
        gcd(n,d)
    }

    operator fun times(other: Rational) = Rational(this.n*other.n, this.d*other.d)
    operator fun div(other: Rational) = Rational (this.n*other.d, other.n*this.d)
    operator fun plus(other: Rational) = Rational (this.n*other.d + other.n*this.d,
                                                    this.d*other.d)
    operator fun minus(other: Rational) = Rational(this.n*other.d - other.n*this.d,
                                                    this.d*other.d)


}

operator fun Int.times(r: Rational) = Rational(this*r.n, r.d)

val Int.rational : Rational
    get() = Rational (this, 1)

fun main(args: Array<String>){
    val a = Rational(22,7)
    val b = Rational(3,5)

    val c = a*b

    println("$a times $b is $c")

    val r = Rational(3,9)

    println (2. times (r))

    println (45. rational )
}




