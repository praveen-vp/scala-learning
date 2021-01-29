package com.pvp
package lectures.part2oop

/**
 * Created by praveen-vp on 11/27/2020
 *
 */
object MethodNotations extends App {

  val praveen = new Person("praveen", "Comedy")

  println(praveen.likes("Comedy"))
  println(praveen likes "Comedy") // equivalent to above
  // it is called infix notation or operator notation
  ///////////////////////////////////////////////////////
  // NOTE WORKS ONLY FOR METHODS WITH ONLY ONE PARAMETER
  ///////////////////////////////////////////////////////

  println(praveen + "addString test")
  println(praveen.+("as param"))

  ///////////////////////////////////////////////////////
  // ALL OPERATORS IN SCALA ARE METHODS
  ///////////////////////////////////////////////////////

  //  prefix notations
  val x = -1
  val y = 1.unary_-
  // unary operators works only with + - ~ !
  println(praveen.unary_!)
  println(!praveen)

  // postfix notations // only available to methods without parameters
  println(praveen.isActive)
  println(praveen isActive)

  // apply method
  println(praveen.apply())
  println(praveen()) // equivalent

  // exercises
  /*
   * 1. overload + operator
   * when overloaded the method should return the a new Person with name concatenated with "rock
   * star"
   *
   * 2. Add an age field to the person class
   *  use unary + operator => a new person with age incremented
   *
   * 3. add a learns method in person class with a parameter and return a string, and a new
   * method learnScala which calls learn method with string "scala"
   * Use as postfix notation
   *
   * 4. overload apply() to receive a int and return a String
   *
   */

  // Ex.1
  println(praveen + "rock star")
  println((+praveen).age)
  println(praveen.learnScala())
  println(praveen learnScala) // syntax sugar

  println(praveen(2)) // calls apply method overloaded

  class Person(val name: String, favMovie: String, val age: Int = 0) {

    def likes(movie: String): Boolean = movie == favMovie

    def isActive: Boolean = true

    def apply(): String = s"$name calling apply method"

    def +(nickName: String): Person = new Person(s"$name ($nickName)", favMovie, age)

    def unary_! : String = s"$name says what the heck !!!!" // prefix

    def unary_+ : Person = new Person(name, favMovie, age + 1) // prefix

    def learnScala(): String = learns("scala")

    def learns(aString: String): String = s"$name learns $aString"

    def apply(int: Int): String = s"$name calling overloaded apply method"

    def print(): Unit = {
      println(name + ", " + favMovie + ", " + age)
    }
  }

}
