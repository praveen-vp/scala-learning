package com.pvp
package lectures.basics

/**
 * Created by praveen-vp on 11/26/2020
 */
object ValuesVariablesTypes extends App {

  // VALS ARE IMMUTABLE
  val x: Int = 40
  println(x)

  //Types for Vals are optional,
  // Compiler can infer types
  val y = 44;
  println(y)

  val aString: String = "hello scala"
  println(aString)
  val anotherString = "hey Scala"
  println(anotherString)

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = 111
  val aShort: Short = 1111
  val aLong: Long = 123456789L
  val aFloat: Float = 1.2f
  val aDouble: Double = 3.14

  // Variables
  // VARIABLES are MUTABLE

  var stringVar : String = "a String variable"
  stringVar = "changing stringVar value" // side effects

  //NOTE :  prefer vals over vars

}
