package com.pvp
package lectures.basics

/**
 * Created by praveen-vp on 11/26/2020
 *
 */
object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value : " + x)
    println("by value : " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name : " + x)
    println("by name : " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime()) // two different value is printed because the callByName
  // function which is passed is evaluated at time of invocation

  def infinite(): Int = 1 + infinite()

  def printFirst(x: Int, y: => Int): Unit = println(x)

  printFirst(34, infinite())
  // printFirst(infinite(), 34) // throws stack overflow error

  // NOTE
  // when the called by value, a function the value is passed
  // when called by name, the function will be called when the calling functions is using the
  // parameter

}
