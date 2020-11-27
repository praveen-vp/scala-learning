package com.pvp
package lectures.basics

import scala.annotation.tailrec

/**
 * Created by praveen-vp on 11/27/2020
 *
 */
object DefaultArgs extends App {

  @tailrec
  def tailRecFactorial(n: Int, accumulator: Int): Int =
    if (n <= 1) accumulator
    else tailRecFactorial(n - 1, n * accumulator)

  println(tailRecFactorial(10, 1))

  // Here we call the tailRecFactorial function with accumulator value as always 1,
  // scala enable us to use default parameters, hence we no need to pass the accumulator value in
  // while calling the function. For that the function need to be changed as below.

  @tailrec
  def tailRecFactorialDefault(n: Int, accumulator: Int = 1): Int =
    if (n <= 1) accumulator
    else tailRecFactorialDefault(n - 1, n * accumulator)

  println(tailRecFactorialDefault(10))

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit =
    println("saving a picture")

  savePicture("jpg", 100, 200) // call the function with same order of params
  savePicture() // call the functions with no params, as all are params are default

  // FIXME
  // savePicture(100, 200) // this will fail as the compiler is not able to parse this
  // FIXES are available as below options
  savePicture("jpg") // call the function always with leading argument
  savePicture(width = 100, height = 200, format = "png") // calling the function with naming the
  // argument, this case we can pass the parameters in any order as the parameter name also being
  // passed.
  // other options available and all other combinations
  savePicture(width = 100)
  savePicture(format = "png")
  savePicture(format = "png", height = 100)
}
