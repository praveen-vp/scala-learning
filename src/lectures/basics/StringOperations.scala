package com.pvp
package lectures.basics

/**
 * Created by praveen-vp on 11/27/2020
 *
 */
object StringOperations extends App {

  val str: String = "Hi I'm learning Scala"

  println(str.charAt(3))
  println(str.substring(3, 8))
  println(str.split(" ").toList)
  println(str.startsWith("Hi"))

  println(str.replace(" ", "--"))
  println(str.toLowerCase)
  println(str.toUpperCase)
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // String Interpolator
  val name = "Praveen"
  val age = 10
  val greeting = s"Hi my name is $name and I'm $age years old"
  println(greeting)

  val anotherGreetings = s"Hi My name is $name and I'm turning ${age + 1} this year"
  println(anotherGreetings)

  // F interpolator
  val speed = 2.2900f
  val myth = f"$name%s can eat $speed%2.3f burgers per minutes"
  println(myth)

  // raw interpolator
  println(raw"this is a \n newline")
  val newLine = "this is a \n new line"  // \n is not escaped here and will be printed as '\n'
  println(raw"$newLine") // \n is escaped and printed as newline


}
