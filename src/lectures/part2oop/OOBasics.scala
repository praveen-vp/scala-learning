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
  val p2 = new Person("John 2")
  println(p2.age)
  p2.greet("Praveen VP ")

  // writer class testing
  val author = new Writer("praveen", "v-p", 1990)
  println(author.getFullName)

  // Novel class testing
  val novel = new Novel("novel name", 2000, author)
  println(novel.writersAge)
  println(novel.isWrittenBy(author)) // true

  val author2 = new Writer("praveen", "v-p", 1990)
  println(novel.isWrittenBy(author2)) // false


  // Counter Class testing
  val counter = new Counter
  counter.inc
  counter.inc.inc
  counter.dec
  counter.inc(3)
}


class Person(name: String, val age: Int = 0) { // as constructor

  val x = 12
  println(x) // this will be invoked when the class is invoked, class as a code block

  def greet(name: String): Unit =
    println(s"${this.name} says : Hi $name")

  // auxiliary constructors
  def this(name: String) = this(name, 0)

  def this() = this("")

  // NOTE ---- > a constructor can only call another constructor with more params/arguments
  // this can be solved by using default arguments used in the functions

}

/**
 * create a class with parameters as below
 *
 * firstName
 * lastName
 * yearOfBirth
 *
 * Create a method for getting full name
 */
class Writer(val firstName: String, val lastName: String, val yearOfBirth: Int) {

  def getFullName: String =
    this.firstName + " " + this.lastName
}

/**
 * Create a class as Novel containing Writer class and parameters as 1. name, 2, year of release
 * method to get
 *  1. author age at the time of release
 *     2. isWrittenBy(author)
 *     3.
 */

class Novel(val name: String, val yearOfRelease: Int, val author: Writer) {

  def writersAge = this.yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Writer) = this.author == author

  def copyRelease(newYear: Int): Novel = new Novel(this.name, newYear, this.author)
}

/**
 * Counter class
 * receives an int value
 * method to get current count
 * method to dec/increment count => new counter
 * overload methods dec/increment on a received input
 */
class Counter(val count: Int = 0) {

  def currentCount = this.count

  def inc: Counter = {
    println("incrementing...")
    new Counter(this.count + 1)
  } // immutability

  def dec: Counter = {
    println("decrementing ... ")
    new Counter(this.count - 1)
  } // immutability

  // overloaded methods
  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def printCount = println(count)
}