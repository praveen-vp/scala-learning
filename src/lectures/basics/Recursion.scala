package com.pvp
package lectures.basics

import scala.annotation.tailrec

/**
 * Created by praveen-vp on 11/26/2020
 *
 */
object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("computing factorial of n " + n + " first need to compute the factorial of " + (n - 1))
      var result = n * factorial(n - 1)
      println("computed factorial of " + n)
      result
    }
  }

  println(factorial(10))

  def anotherFactorials(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else
        factorialHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as LAST Expression
    }

    factorialHelper(n, 1)
  }

  println(anotherFactorials(10))

  // USE TAIL RECURSION WHEN YOU NEED LOOPS
  // 1. concatenate a string n times

  def concatenateString(aString: String, n: Int): String = {

    @tailrec
    def concatenateHelper(x: Int, accumulator: String): String = {
      if (x == 1) accumulator
      else concatenateHelper(x - 1, aString + accumulator)
    }

    concatenateHelper(n, aString)
  }

  println(concatenateString("hello ", 4))

  @tailrec
  def concatenateTailRec(aString: String, x: Int, accumulator: String): String = {
    if (x <= 0) accumulator
    else concatenateTailRec(aString, x - 1, aString + accumulator)
  }

  println(concatenateTailRec("hello tailrec ", 4, ""))

  // 2. isPrime function using tail recursion
  def isPrime(n: Int): Boolean = {

    @tailrec
    def isPrimeTailRec(x: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (x <= 1) true
      else isPrimeTailRec(x - 1, (n % x) != 0 && isStillPrime)
    }

    isPrimeTailRec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(2007))
  println(isPrime(200))

  // 3. Fibonacci series using tail recursion
  def fibonacciNumber(n: Int): Int = {

    @tailrec
    def fibonacciTailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fibonacciTailRec(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    fibonacciTailRec(2, 1, 1)
  }

  println(fibonacciNumber(8)) // 1 1 2 3 5 8 13 21

}
