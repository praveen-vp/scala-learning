package com.pvp
package lectures.basics

import scala.annotation.tailrec

/**
  * Created by praveen-vp on  11/26/2020
  *
  */
object Functions extends App {

  def simpleFunction(a: String, b: Int) = a + " " + b

  println(simpleFunction("eee", 3))

  def noParamFunction(): Int = 44;
  println(noParamFunction())
  println(noParamFunction) // still valid

  // recursive functions for loops
  def repeatingFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + repeatingFunction(aString, n - 1)
  }

  println(repeatingFunction("hello ", 3))
  // WHEN YOU NEED TO LOOPS USE RECURSION

  // Function with side effects
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  // Big Functions or functions inside functions

  def aBigFunction(n: Int): Int = {
    def aSmallFunction(x: Int, y: Int): Int = x + y
    aSmallFunction(n, n - 1)
  }

  println(aBigFunction(5))

  // a greeting function with name and age

  def greetings(name: String, age: Int): String =
    "Hi I'm " + name + " and I'm " + age + " years old"

  println(greetings("praveen", 10))

  // factorial
  // 1 * 2 * 3 * 4 ...

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  println("factorial :: " + factorial(9))

  // fibonacci series
  // f(1) = 1, f(2) = 1, f(n) = f(n-1) + f(n-2)

  def fibonacciNumber(n: Int): Int = {
    if (n <= 2) 1
    else fibonacciNumber(n - 1) + fibonacciNumber(n - 2)
  }

  println(fibonacciNumber(4))

  // prime number check
  def isPrime(n: Int): Boolean = {

    @tailrec
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  println(isPrime(37))
  println(isPrime(3001))
  println(isPrime(37 * 17))
}
