package com.pvp
package lectures.part2oop

/**
 * Created by praveen-vp on 11/29/2020
 *
 */
object Objects extends App {

  ////////////////////////////////////////////////////////////////////
  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY AS static in JAVA//
  ////////////////////////////////////////////////////////////////////
  // SCALA HAVE OBJECTS//
  ///////////////////////

  object Person {
    // "class"/"static" level functionality
    val NUM_2 = 2

    def canFly = false

    // a factory method in the objects and usually name it as apply, so we can access the method
    // as a constructor, as mentioned in the method notations
    def apply(mother: Person, father: Person): Person = new Person("new person child")
  }

  class Person(name: String) {
    // instance level functionality
  }

  println(Person.NUM_2)
  println(Person.canFly)
  // objects do not receive parameters, can have methods, var-s and val-s

  // SCALA Objects are SINGLETON Instance
  val vp = Person
  val pp = Person
  println(pp == vp) // this will return true as both pp and vp are pointing to same instance

  val mary = new Person("mary")
  val boby = new Person("Boby")
  ///// COMPANIONS /////
  //// Companions can access each others private members
  // Writing the classes and objects with same name in same scope and keeping the functionalities
  // both as per the nature of the functionality
  //// calling the factory method apply as a constructor of the object
  val childPerson = Person(mary, boby)

}

// Scala applications are the objects with method
// def main (args : String[]) : Unit
// or we can create an application extending 'App' object
// eg : object SubApp extends App


