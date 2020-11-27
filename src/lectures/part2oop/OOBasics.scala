package com.pvp
package lectures.part2oop

/**
 * Created by praveen-vp on 11/27/2020
 *
 */
object OOBasics extends App {

  val person = new Person("praveen", 11)
  println(person.age)
  person.greet("john")
  val  p2 = new Person("John 2")
  println(p2.age)
  p2.greet("Praveen VP ")
}


class Person(name: String, val age: Int = 0) { // as constructor

  val x = 12
  println(x) // this will be invoked when the class is invoked, class as a code block

  def greet(name: String): Unit =
    println(s"${this.name} says : Hi $name")

  // auxiliary constructors
  def this(name: String) = this(name, 0)

  def this() = this("")

  // NOTE ---- > a constructor can only call another constructor.
  // this can be solved by using default arguments used in the functions

}
